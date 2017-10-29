package swiggy.models;

import java.util.Date;

public class DeliveryExecutive{
	private int id;
	private Location location; //location of executive
	private Date lastOrderTime;

	public DeliveryExecutive(int id, Location l, Date lastOrderTime) {
		   this.setId(id);
		   this.location=l;
		   this.setLastOrderTime(lastOrderTime);
		}


	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public Date getLastOrderTime() {
		return lastOrderTime;
	}

	public void setLastOrderTime(Date lastOrderTime) {
		this.lastOrderTime = lastOrderTime;
	}

	public Location getLocation() {
		return location;
	}

	public void setLocation(Location location) {
		this.location = location;
	}
	
	
}
