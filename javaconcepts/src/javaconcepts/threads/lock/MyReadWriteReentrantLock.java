package javaconcepts.threads.lock;

import java.util.HashMap;
import java.util.Map;

/*
 * A thread is granted read reentrance if it can get read access (no writers or write requests), 
 * or if it already has read access (regardless of write requests). or if it is a writer
 * 
 * Write reentrance is granted only if the thread has already write access.
 * 
 * import java.util.concurrent.locks.ReadWriteLock; //Lock readLock();  Lock writeLock();
 * import java.util.concurrent.locks.ReentrantReadWriteLoc
 * Java ReadWriteLock readWriteLock = new ReentrantReadWriteLock();
 * readWriteLock.readLock().lock();
 * readWriteLock.readLock().unlock();
 * readWriteLock.writeLock().lock();
 * readWriteLock.writeLock().unlock();
 *  
 */

public class MyReadWriteReentrantLock {

	private Map<Thread, Integer> readingThreads = new HashMap<Thread, Integer>();
	private int writers = 0;
	private int writeRequests = 0;
	private Thread writingThread = null;

	public synchronized void readLock() throws InterruptedException {
       while(!canGetReadAccess()) {
    	   wait();
       }
       if(readingThreads.get(Thread.currentThread())!=null) {
    	   readingThreads.put(Thread.currentThread(), readingThreads.get(Thread.currentThread())+1);
       }else {
    	   readingThreads.put(Thread.currentThread(), 1);
       }
	}

	public synchronized void readUnlock() {
		if (readingThreads.get(Thread.currentThread()) != null) {
			if(readingThreads.get(Thread.currentThread())==1) {
				readingThreads.remove(Thread.currentThread());
			}else {
				readingThreads.put(Thread.currentThread(), readingThreads.get(Thread.currentThread()) - 1);
			}
		}
	}

	public synchronized void writeLock() throws InterruptedException {
       writeRequests++;
       while(!canGetWriteAccess()) {
    	   wait();
       }
       writeRequests--;
       writers++;
       writingThread = Thread.currentThread();
		
	}

	public synchronized void writeUnlock() {
		writers--;
		if (writers == 0) {
			writingThread = null;
		}
		notifyAll();
	}
	


	private boolean canGetWriteAccess() {
		if(readingThreads.size()>0) return false;
		if(writingThread == Thread.currentThread())return true;
		if(writers > 0) return false;
		return true;
	}
	
	private boolean canGetReadAccess() {
		//if no write request, writer or if it is the same thread that has lock
		if(writingThread == Thread.currentThread())return true;
		if(writers>0)return false;
		if(readingThreads.get(Thread.currentThread())!=null)return true;
		if(writeRequests > 0)return false;
		return true;
	}

}
