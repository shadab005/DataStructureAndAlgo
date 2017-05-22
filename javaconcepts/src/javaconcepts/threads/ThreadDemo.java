package javaconcepts.threads;


class ThreadDemo extends Thread {
	ThreadDemo() {
		super("ChildThread");
		start();
		System.out.println(getName() + " started here...... ");
	}

	public void run() {
		for (int i = 0; i < 4; i++) {
			System.out.println(" Inside " + getName() + "  i= " + i);
			try {
				sleep(1000);
			} catch (Exception e) {
				System.out.println("Error is " + e);
			}
		}
		System.out.println(getName() + " end here=======>");
	}
	public void fun(){
		System.out.println("Hello");
	}

	public static void main(String arg[]) {
		Thread th1 = Thread.currentThread();
		System.out.println(th1.getName() + " thread started here=====>");
		ThreadDemo rd = new ThreadDemo();
		for (int i = 0; i < 4; i++) {
			System.out.println(" Inside " + th1.getName() + "  i= " + i);
			try {
				Thread.sleep(1000);
			} catch (Exception e) {
				System.out.println("Error is " + e);
			}
		}
		rd.fun();
		System.out.println(" Main thread ends here=======>");
	}
}
