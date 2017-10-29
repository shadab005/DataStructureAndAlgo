package module.elevator;

public class StopButton implements Button {

	private ElevatorController controller;
	
	public StopButton(ElevatorController controller){
		this.controller=controller;
	}
	
	@Override
	public void pushButton(int buttonId) {
		
		
	}

}
