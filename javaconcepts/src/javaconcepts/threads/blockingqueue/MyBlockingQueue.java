package javaconcepts.threads.blockingqueue;

import java.util.ArrayDeque;
import java.util.Queue;

/*
 * BlockingQueue<String> queue = new ArrayBlockingQueue<>(1024);
 * queue.put("1");
 * String string = queue.take();
 * 
 */
public class MyBlockingQueue<T> {

	private Queue<T> queue;
	private int size ;
	public MyBlockingQueue(int size) {
		this.size = size;
		queue = new ArrayDeque<>(size);
	}
	
	public synchronized void put(T e) {
		while(queue.size() == size) {
			try {
				wait();
			} catch (InterruptedException e1) {
				e1.printStackTrace();
			}
		}
		queue.add(e);
		if(queue.size() == 1) {
		      notifyAll();
		}
	}
	
	public synchronized T take() {
		while(queue.size()==0) {
			try {
				wait();
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
		T element = queue.remove();
		if(queue.size() == size-1){
		      notifyAll();
		}
		notifyAll();
		return element;
	}
}
