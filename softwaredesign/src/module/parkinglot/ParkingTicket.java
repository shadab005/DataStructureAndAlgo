package module.parkinglot;

import java.util.Date;

public class ParkingTicket {
	
	private int id;
	
	private Vehicle vehicle;
	
	private Date parkingTime;
	
    private Slot slot;

	public Vehicle getVehicle() {
		return vehicle;
	}

	public void setVehicle(Vehicle vehicle) {
		this.vehicle = vehicle;
	}

	public Date getParkingTime() {
		return parkingTime;
	}

	public void setParkingTime(Date parkingTime) {
		this.parkingTime = parkingTime;
	}

	public Slot getSlot() {
		return slot;
	}

	public void setSlot(Slot slot) {
		this.slot = slot;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

}
