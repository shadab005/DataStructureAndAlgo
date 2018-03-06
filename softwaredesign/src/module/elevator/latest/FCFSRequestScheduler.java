package module.elevator.latest;

public class FCFSRequestScheduler implements RequestScheduler{

	//Queue 
	private boolean isAlive = true;
	private Elevator elevator;
	@Override
	public void addRequest(Request request) {
		// TODO Auto-generated method stub
		
	}
	
	public void run() {
		while(isAlive) {
			Request request = fetchNextRequest();
			elevator.moveToFloor(request.getFloor());//10s
		}
	}

	private Request fetchNextRequest() {
		// TODO Auto-generated method stub
		// remove from queue
		return null;
	}

}
