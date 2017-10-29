package module.elevator;

public class Elevator {

	public enum State{
		MOVING,STOP;
	}
	
	int currentFloor;
	State s;
	
	public void moveToFloor(int floor){
		s = State.MOVING;
		System.out.println("Elevator moving to floor " + floor);
		try {
			Thread.sleep(1000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		System.out.println("Elevator moved to floor " + floor);
		s = State.STOP;
	}
	
	public void stopElevator() {
		s=State.STOP;
	}
}
