package module.uber;

/*
 * Server side manager to communicate to specific cab handling the trip.
 */
public class CabManager {

	CabServiceConnectionManager cabServiceConnectionManager;

	public void updateCabWithTrip(Trip trip) {
		CabService cabService = cabServiceConnectionManager.getCabService(trip.getCab().getId());
		cabService.updateTripInfo(trip);
		
	}

	public void cancelTripWithCab(Trip trip) {
		CabService cabService = cabServiceConnectionManager.getCabService(trip.getCab().getId());
		cabService.cancelTrip(trip.getTripId());
	}
	
}

