package module.parkinglot;

public class Client {
	
	private static ParkingManager parkingManager;

	public static void main(String[] args) {
		
		testParking();

	}

	private static void testParking() {
		Vehicle v = new Vehicle();
		v.setType(VehicleType.SEDAN);
		
		ParkingTicket ticket = parkingManager.park(v);
		
		//Printing details about ticket
		System.out.println(ticket.getId() + " " + ticket.getSlot() + " " + ticket.getParkingTime() + " " + ticket.getVehicle());
		
		parkingManager.unpark(ticket.getId());
		
		
		
	}

}
