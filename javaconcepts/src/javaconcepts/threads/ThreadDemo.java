package javaconcepts.threads;

class ThreadDemo extends Thread {
	int i;
	Runnable target;
	ThreadDemo(Runnable r) {
		target = r;
	}
	ThreadDemo(int i) {
		super("ChildThread");
		this.i= i;
//		start();
		System.out.println(getName() + i + " started here...... ");
	}

	@Override
	public void run() {
		System.out.println("Inside run method of ThreadDemo");
		for (int i = 0; i < 4; i++) {
			System.out.println(" Inside " + getName() + " ins = " + this.i + "  i= " + i);
			try {
				sleep(1000);
			} catch (Exception e) {
				System.out.println("Error is " + e);
			}
		}
		try {
			Thread.sleep(2000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		System.out.println(getName() + this.i + " end here=======>");
	}

	public void fun() {
		System.out.println("Hello");
	}

	public static void main(String arg[]) {
		Thread th1 = Thread.currentThread();
		System.out.println(th1.getName() + " thread started here=====>");
		ThreadDemo rd = new ThreadDemo(0);
		ThreadDemo rd2 = new ThreadDemo(2);
		for (int i = 0; i < 4; i++) {
			System.out.println(" Inside " + th1.getName() + "  i= " + i);
			try {
				Thread.sleep(1000);
			} catch (Exception e) {
				System.out.println("Error is " + e);
			}
		}
		rd.fun();
		try {
			rd.join();
			th1.join();
//			rd2.join();
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		System.out.println(" Main thread ends here=======>");
	}
}
