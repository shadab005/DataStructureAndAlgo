package module.elevator.latest;

public class Request {

	private int floor;
	
	Request(int floor){
		this.setFloor(floor);
	}

	public int getFloor() {
		return floor;
	}

	public void setFloor(int floor) {
		this.floor = floor;
	}
	
}
