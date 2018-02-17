package javaconcepts.threads.lock;

/*
 * Simple lock as in java.util.concurrent.locks.Lock(Inteface)
 * This is non-reentrant.
 * 
 * ex: void f1()
 * {
 *   lock.lock();
 *   //cs
 *   f2();
 *   lock.unlock();
 * }
 * 
 * void f2(){
 * lock.lock();
 * //cs
 * lock.unlock();
 * }
 * 
 * thread entring f1() takes lock but when f2() is called within then on the same lock it gets blocked. Therefore non reentrant.
 * This would not have been the case had we used syncronized keyword which is reentrant by nature. 
 */
public class MyLock {

	private boolean isLocked = false;
	private Thread lockingThread;

	public synchronized void lock() {
		while (isLocked) {
			try {
				wait();
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		isLocked = true;
		lockingThread = Thread.currentThread();
	}

	public synchronized void unlock() {
		if (Thread.currentThread() == lockingThread) {
			isLocked = false;
			notifyAll();
		}
	}
}
