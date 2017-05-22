package javaconcepts.threads;

public class Test {

	public static void main(String[] args) {
		Thread t1 = new Thread("test-1");
		Thread t2 = new Thread("test-2");
		t2.run();
		t1.run();
		System.out.println(Thread.activeCount());
		System.out.println(Thread.currentThread().getName());
		System.out.println(Thread.currentThread().getPriority());
		try {
			Thread.sleep(3000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		System.out.println(t1.isAlive());
	}

}
