package module.uber;

public class Cab {

	private String id;

	private CabType type;

	private Location loc;

	private Driver driver;

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public CabType getType() {
		return type;
	}

	public void setType(CabType type) {
		this.type = type;
	}

	public Location getLoc() {
		return loc;
	}

	public void setLoc(Location loc) {
		this.loc = loc;
	}

	public Driver getDriver() {
		return driver;
	}

	public void setDriver(Driver driver) {
		this.driver = driver;
	}

}
