package javaconcepts.threads;

import java.util.LinkedList;
import java.util.Queue;

class Resource {

	// queue as fixed buffer size
	Queue<Integer> q = new LinkedList<>();
	int bufferSize = 10;

	synchronized void get(Thread t) {
		if (q.isEmpty()) {
			try {
				System.out.println(t.getName() + " is now in wait state");
				wait();
				System.out.println(t.getName() + " is now in " + t.getState());

			} catch (InterruptedException e) {
				System.out.println("InterruptedException caught");
			}
		} else {
			System.out.println(
					t.getName() + " " + "[" + t.getId() + "]" + " csume<--" + q.remove() + " buffer size= " + q.size());
			notifyAll();
		}
		/*
		 * try { Thread.sleep(1000); } catch (InterruptedException e) {
		 * System.out.println("Exception Occured");
		 *
		 * }
		 */
	}

	synchronized void put(int x, Thread t) {
		if (q.size() >= bufferSize) {
			try {
				System.out.println(t.getName() + " is now in wait state");
				wait();
				System.out.println(t.getName() + " is now in " + t.getState());
			} catch (InterruptedException e) {
				System.out.println("InterruptedException caught");
			}
		}
		if (q.size() < bufferSize) {
			q.add(x);
			System.out
					.println(t.getName() + " " + "[" + t.getId() + "]" + " feeds-->" + x + " buffer size= " + q.size());
			notifyAll();
		}
		try {
			Thread.sleep(20000);
		} catch (InterruptedException e) {
			System.out.println("catch of sleep");
		}
	}

	public void funWithOutLock() {
		System.out.println("Lallllllllllla");
		try {
			Thread.sleep(1000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		System.out.println("Jajjajaja");
	}

	public synchronized void funWithLock() {
		System.out.println("Lockkkkkkkkkkkkkkkkk");
		try {
			Thread.sleep(3000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		System.out.println("Hahhahaaaaaaaaaaaaa");
	}
}

class Producer implements Runnable {
	Resource qp;
	Thread t;

	Producer(Resource q, String name) {
		this.qp = q;
		t = new Thread(this, name);
		t.start();
	}

	@Override
	public void run() {
		int i = 0;

		while (true) {
			qp.put(i++, t);
			/*
			 * try { Thread.sleep(20000); } catch (InterruptedException e) {
			 * System.out.println("catch of sleep"); }
			 */

		}
	}
}

class Consumer implements Runnable {

	Resource qc;
	Thread t;

	Consumer(Resource q, String name) {

		this.qc = q;
		t = new Thread(this, name);
		t.setPriority(Thread.MAX_PRIORITY);
		t.start();
	}

	@Override
	public void run() {
		while (true) {
			qc.get(t);

		}

	}
}

public class ProducerConsumerProblem {

	public static void main(String[] args) throws InterruptedException {
		Resource q = new Resource();
		System.out.println("Creating new producer 1");
		Producer p1 = new Producer(q, "producer 1");
		System.out.println("Creating new consumer 1");
		Consumer c1 = new Consumer(q, "consumer 1");
		System.out.println("Creating new producer 2");
		Producer p2 = new Producer(q, "producer 2");
		System.out.println("Creating new consumer 2");
		Consumer c2 = new Consumer(q, "consumer 2");
		try {

			p1.t.join();
			p2.t.join();
			c1.t.join();
			c2.t.join();

		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
