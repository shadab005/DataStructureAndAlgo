package design_pattern.creational;

/*
 * It provides a way to delegate the instantiation logic to child classes.
 * Use the Factory Method when you don’t know beforehand the exact types and dependencies of the objects your code should work with.
 * 
 * class A
 * class B extends A
 * class C extends A
 * 
 * Corresponding factory
 * class FactoryA : A createProduct(); void otherMethod()
 * class FactoryB extends FactoryA: A createProduct()
 * class FactoryC extends FactoryA: A createProduct()
 * 
 * 
 */

interface Transport {
	void deliver();
}

class Truck implements Transport {
	@Override
	public void deliver() {
	}
}
class Ship implements Transport {
	@Override
	public void deliver() {
	}
}

//Factory
	abstract class Logistics { //Base Factory class
	    public void planDelivery() {
	    	Transport t = createTransport();
	    	t.deliver();
	    }
		abstract Transport createTransport();
	}
	
  class RoadLogistics extends Logistics {
		public Transport createTransport() {
			return new Truck();
			
		}
	}
	
	class SeaLogistics extends Logistics {
		public Transport createTransport() {
			return new Ship();
			
		}
	}
	

public class FactoryMethod {
	public static void main(String[] args) {
		Logistics logistic = new RoadLogistics();
		logistic.planDelivery();
	}

}

