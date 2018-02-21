package module.elevator.latest;

import java.util.List;

import module.elevator.latest.Elevator;

public class ElevatorManager {
	
	List<Elevator> elvators;
	
	ElevatorSelector selector;
	
	public void handleRequest(Request request) {
		Elevator elevator = selector.assignElevatorForRequest(request);
		elevator.serveRequest(request);
	}

}
