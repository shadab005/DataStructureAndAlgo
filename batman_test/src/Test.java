public class Test {

	public static void main(String[] args) throws InterruptedException {
		fun();
		

	}
	
	static void fun() {
		
		try {
			System.out.println("Try block");
			String s = null;
			//s.toLowerCase();
			System.out.println("Je");
			return;
		} finally {
			System.out.println("Finally block");
		}
		//System.out.println("Returning");
	}
}