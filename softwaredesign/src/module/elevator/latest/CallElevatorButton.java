package module.elevator.latest;

public class CallElevatorButton implements Button{

	private final int floor;
	
	private ElevatorManager elevatorManager;
	
	public CallElevatorButton(int floor, ElevatorManager mgr){
		this.floor = floor;
		elevatorManager = mgr;
	}
	
	@Override
	public void onButtonPress() {
		elevatorManager.handleRequest(new Request(floor));
	}
}
