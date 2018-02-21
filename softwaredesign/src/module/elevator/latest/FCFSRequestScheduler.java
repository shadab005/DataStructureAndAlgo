package module.elevator.latest;

public class FCFSRequestScheduler implements RequestScheduler{

	private boolean isAlive = true;
	private Elevator elevator;
	@Override
	public void addRequest(Request request) {
		// TODO Auto-generated method stub
		
	}
	
	public void run() {
		while(isAlive) {
			Request request = fetchNextRequest();
			elevator.moveToFloor(request.getFloor());
		}
	}

	private Request fetchNextRequest() {
		// TODO Auto-generated method stub
		return null;
	}

}
