package module.elevator.latest;

public class FloorButton implements Button{

	private final int floor;
	
	private Elevator elevator;
	
	public FloorButton(int floor) {
		this.floor = floor;
	}

	@Override
	public void onButtonPress() {
		// TODO Auto-generated method stub
		elevator.serveRequest(new Request(floor));		
	}
}
