package javaconcepts.threads;

public class ThreadSequence implements Runnable {

	static int n = 1;
	static int rem = 1;
	Object obj = new Object();

	public static void main(String[] args) {
		Runnable task = new ThreadSequence();
		Thread t1 = new Thread(task, "1");
		Thread t2 = new Thread(task, "2");
		Thread t3 = new Thread(task, "3");
		t1.start();
		t2.start();
		t3.start();

	}

	@Override
	public synchronized void run() {
		try {
			Thread.sleep(100);
			while (true) {
				//System.out.println(Thread.currentThread().getName());
				Thread.sleep(100);
				switch (Thread.currentThread().getName()) {
				case "1":
					if (n % 3 == 1) {
						print(n, Thread.currentThread().getName());
						n++;
						notify();
					} else {
						notify();
						wait(5);
					}
					break;
				case "2":
					if (n % 3 == 2) {
						print(n, Thread.currentThread().getName());
						n++;
						notify();
					} else {
						notify();
						wait(5);
					}
					break;

				case "3":
					if (n % 3 == 0) {
						print(n, Thread.currentThread().getName());
						n++;
						notify();
					} else {
						notify();
						wait(5);
					}
					break;
				}
			}
		} catch (Exception e) {
			e.printStackTrace();
		}

	}

	private void print(int n2, String name) {
		System.out.println(n2 + " :: " + name);

	}

}
