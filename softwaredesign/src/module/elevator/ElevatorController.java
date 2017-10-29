package module.elevator;

public class ElevatorController {
	private Elevator elevator;
	private SchedulingAlgo algo;
	
	public ElevatorController(Elevator elevator, SchedulingAlgo algo) {
		this.elevator = elevator;
		this.algo = algo;
	}

	public void moveElevatorToFloorRequest(int floor) {

	}

	public void stopElevatorRequest(int floor) {

	}
	
	public void getNextRequest(){
		int floor = algo.getNextFloor();
		elevator.moveToFloor(floor);
	}

}
