package module.restaurant;

public class Table {

	private boolean isOccupied;
	private int id;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}
	
	public boolean isOccupied() {
		return isOccupied;
	} 
	
	public void setIsOccupied(boolean isOccuped) {
		this.isOccupied = isOccuped;
	}
	
}
