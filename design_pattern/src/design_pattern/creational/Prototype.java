package design_pattern.creational;

import java.util.HashMap;
import java.util.Map;

/*
 * Create object based on an existing object through cloning.
 * 
 * When to use? 
 * When an object is required that is similar to existing object or when the creation would be expensive as compared to cloning.
 */

interface Car extends Cloneable {
	public Car clone();
	public void drive();
}

class Mercedes implements Car{
	
	public Mercedes() {}
	
	public Mercedes(Mercedes m) {
		
	}
	
	public Car clone() {
		return new Mercedes(this);
	}

	@Override
	public void drive() {
	}
}

class Lamborgini implements Car{
	
	public Lamborgini() {}
	
	public Lamborgini(Lamborgini m) {
		
	}
	
	public Car clone() {
		return new Lamborgini(this);
	}

	@Override
	public void drive() {
	}
}

class CarPrototypeFactory {
	private static Map<String, Car> carMap = new HashMap<>();
	static {
		carMap.put("MERCEDES", new Mercedes());
		carMap.put("LAMBORGINI", new Lamborgini());
	}
	
	public Car getCar(String carType) {
		//Using prototype pattern to create new instance of car every time using cloning technique
		return carMap.get(carType).clone();
	}
}
public class Prototype {

	public static void main(String[] args) {
		CarPrototypeFactory carPrototypeFactory = new CarPrototypeFactory();
		Car car = carPrototypeFactory.getCar("MERCEDES");
		car.drive();

	}

}
