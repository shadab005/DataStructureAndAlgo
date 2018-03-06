package module.uber;

import java.util.List;

/*
 * Server side class. This service class is called by customer App to book and cancel Trip
 */
public class BookingService {
	
	private CabFinder cabFinder;
	private CabSelector cabSelector;
	private TripManager tripManager;
	private CabManager cabManager; //Should internally have the logic to talk to the particular cab based on can Id

	public Trip bookTrip(Request request) {
		List<Cab> cabs = cabFinder.fetchNearByCabs(request.getCabType(), request.getPickUpLocation()); 
		//will internlly invoker service on all driver app and select one
		Cab cab = cabSelector.requestAll(cabs);
		//Create trip for the request and cab
		Trip trip = tripManager.createTrip(cab, request); //will manage the Trip created
		
		//After cab is selected, the cab is updated with information about Trip
		cabManager.updateCabWithTrip(trip);
		
		return trip;
	}
	
	public void cancelTrip(String tripId) {
		Trip trip = tripManager.getTrip(tripId);
		cabManager.cancelTripWithCab(trip);
		tripManager.updateTripStatusForCancellation(tripId);
	}
	
}
