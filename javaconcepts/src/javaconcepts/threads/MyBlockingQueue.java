package javaconcepts.threads;

import java.util.LinkedList;
import java.util.List;

public class MyBlockingQueue {

	@SuppressWarnings("rawtypes")
	private List queue = new LinkedList();
	private int limit = 10;

	public MyBlockingQueue(int maxTask) {
		this.limit=maxTask;
	}

	@SuppressWarnings("unchecked")
	public synchronized void enqueue(Object item) throws InterruptedException {
		while (queue.size() == limit) {
			wait();
		}
		if (this.queue.size() == 0) {
			notifyAll();
		}
		queue.add(item);
	}

	public synchronized Object dequeue() throws InterruptedException {
		while (queue.size() == 0) {
			wait();
		}
		if (this.queue.size() == this.limit) {
			notifyAll();
		}
		return queue.remove(0);
	}

}
