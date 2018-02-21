package module.elevator.latest;

public class StopButton implements Button{
	
	private Elevator elevator;
	
	public StopButton(Elevator e) {
		elevator = e;
	}

	@Override
	public void onButtonPress() {
		elevator.stopElevator();
	}
}
