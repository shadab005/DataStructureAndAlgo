package module.elevator.latest;

public class Elevator {

	private RequestScheduler requestScheduler;
	
	private State state;
	
	private int currentFloor;
	
	public void serveRequest(Request request) {
		requestScheduler.addRequest(request);
	}
	
	public void moveToFloor(int floor) {
		//set state of elevator MOVING_UP or MOVING_DOWN accordingly
		state = (floor>currentFloor) ?  State.MOVING_UP: State.MOVING_DOWN;
		//move
		//change current floor
		//set STATE to IDLE
		state = State.IDLE;
	}
	
	public void stopElevator() {
		
	}

	public State getState() {
		return state;
	}

	public void setState(State state) {
		this.state = state;
	}

	public int getCurrentFloor() {
		return currentFloor;
	}

	public void setCurrentFloor(int currentFloor) {
		this.currentFloor = currentFloor;
	}

}
