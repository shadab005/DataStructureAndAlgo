package module.elevator;

public class FloorButton implements Button{

	private ElevatorController controller;
	public FloorButton(ElevatorController controller){
		this.controller=controller;
	}
	
	@Override
	public void pushButton(int buttonId) {
		controller.getClass();
	}

	
}
