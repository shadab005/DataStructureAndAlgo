package swiggy.models;

import java.util.Date;

public class Order{
	private int id;
	private Date orderTime;//Order time
	private Location location;//location of restro
	
	public Order(int id, Location l, Date time){
		this.id=id;
		this.setLocation(l);
		this.setOrderTime(time);
	}
	

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}


	public Date getOrderTime() {
		return orderTime;
	}

	public void setOrderTime(Date orderTime) {
		this.orderTime = orderTime;
	}

	public Location getLocation() {
		return location;
	}

	public void setLocation(Location location) {
		this.location = location;
	}
	
}