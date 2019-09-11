public class Test {

	public static void main(String[] args) throws InterruptedException  {
		int b[] = new int[] {3,3,2};
		fun(1,b);

	}
	
	static void fun(int x, int... a) {
		int b[] = new int[] {3,3,2};
		System.out.println(a);
		
	}
}