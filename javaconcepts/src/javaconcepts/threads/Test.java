package javaconcepts.threads;

public class Test {

	public static void main(String[] args) throws InterruptedException {
		A a = new A();
		Thread t1 = new Thread(a);
		System.out.println(t1.getName());
		t1.start();
		System.out.println("zzzzzzzzzzzzzzzzz");
	}

}

class A implements Runnable{

	@Override
	public void run() {
		for (int i = 0; i < 100; i++) {
			System.out.println("Hello - " + i);
			try {
				fun();
				Thread.sleep(1000);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
		/*synchronized (this) {
			notifyAll();
		}*/
	}

	synchronized void fun() throws InterruptedException {
		this.wait();
		System.out.println("Hello");
	}
}