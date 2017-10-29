package javaconcepts.threads;

import java.util.ArrayList;
import java.util.List;

public class MyThreadPoolExecutor {

	MyBlockingQueue taskQueue;
	private List<ThreadPool> threads = new ArrayList<ThreadPool>();
	private boolean isStopped = false;

	MyThreadPoolExecutor(int limit, int maxTask) {
		taskQueue = new MyBlockingQueue(maxTask);
		for (int i = 0; i < limit; i++) {
			threads.add(new ThreadPool(taskQueue));
		}

		for (ThreadPool thread : threads) {
			thread.start();
		}
	}

	public synchronized void executeTask(Runnable r) throws InterruptedException {
		if (isStopped)
			throw new IllegalStateException("ThreadPool is stopped");
		taskQueue.enqueue(r);
	}

	public synchronized void stop() {
		this.isStopped = true;
		for (ThreadPool thread : threads) {
			thread.doStop();
		}
	}
}

class ThreadPool extends Thread {

	MyBlockingQueue taskQueue;
	private boolean isStopped = false;

	ThreadPool(MyBlockingQueue q) {
		taskQueue = q;
	}

	@Override
	public void run() {
		while (!isStopped()) {
			try {
				Runnable r = (Runnable) taskQueue.dequeue();
				r.run();
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
	}

	public synchronized void doStop() {
		isStopped = true;
		this.interrupt(); // break pool thread out of dequeue() call.
	}

	public synchronized boolean isStopped() {
		return isStopped;
	}

}