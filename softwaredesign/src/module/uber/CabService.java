package module.uber;

/*
 * Service at driver end. Invoked by central server to request ride confirmation, cancel trip and update trip info
 */
public class CabService {

	public void cancelTrip(String tripId) {
		// TODO Auto-generated method stub
		
	}

	public void updateTripInfo(Trip trip) {
		// TODO Auto-generated method stub
		
	}

	public boolean requestForRideConfirmation() {
		//Ask the driver for confirmation, if accept then return true
		return true;
	}
	
    public Location getCurrentLocation() {
		return null;
    	
    }

}
