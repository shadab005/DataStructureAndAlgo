package design_pattern.creational;

/*
 * Simple factory simply generates an instance for client without exposing any instantiation logic to the client
 * When to use?
 * When creating an object is not just a few assignments and involves some logic, 
 * it makes sense to put it in a dedicated factory instead of repeating the same code everywhere.
 */
public class SimpleFactory {
	
	interface Door {
		float getWidth();
		float getHeight();
	}
	
	static class WoodenDoor implements Door {
		private int height, width;
		WoodenDoor(int h, int w) {
			width = w; height = h;
		}
		@Override
		public float getWidth() {
			return width;
		}
		@Override
		public float getHeight() {
			return height;
		}
	}
	
	static class DoorFactory {
		public static Door makeDoor(int height, int width) {
			return new WoodenDoor(height, width);
		}
	}

	public static void main(String[] args) {
		Door door = DoorFactory.makeDoor(10, 20);
		System.out.println(door.getHeight());

	}

}
