package javaconcepts.threads;

import java.util.concurrent.atomic.AtomicInteger;

public class AtomicIntegerTest implements Runnable{

	AtomicInteger a = new AtomicInteger();
	int x = 0;
	@Override
	public void run() {

		for(int i=0;i<10000;i++) {
			a.getAndIncrement();
			x++;
		}
	}

	public static void main(String[] args) throws InterruptedException {
		AtomicIntegerTest runnable = new AtomicIntegerTest();
		Thread t1 = new Thread(runnable);
		Thread t2 = new Thread(runnable);
		t1.start();
		t2.start();
		t1.join();
		t2.join();
		System.out.println(runnable.a.get());
		System.out.println(runnable.x);
	}


}
