package design_pattern.creational;

/*
 * Allows you to create different flavors of an object while avoiding constructor pollution. 
 * Useful when there could be several flavors of an object. Or when there are a lot of steps involved in creation of an object.
 * You can force the immutability to the object once you are done with creation of object.
 */


class House{

	public boolean hasWalls;
	public boolean hasDoors;
	public boolean hasRoof;
	
}

class HouseBuilder {
	private House house;
	public HouseBuilder() {
		house = new House();
	}
	
	public HouseBuilder buildWalls() {
		house.hasWalls = true;
		return this;
	}
	
	public HouseBuilder buildDoors() {
		house.hasDoors = true;
		return this;
	}
	
	public HouseBuilder buildRoof() {
		house.hasRoof = true;
		return this;
	}
	
	public House build() {
		return house;
	}
}
public class Builder {
	
	public static void main(String args[]) {
		HouseBuilder builder = new HouseBuilder();
		House hosue = builder.buildDoors().buildRoof().buildWalls().build();
	}

}
