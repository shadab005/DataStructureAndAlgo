package javaconcepts.threads.lock;

/*
 * Java ReentrantLock (java.util.concurrent.locks)
 * lock()
 * lockInterruptibly()
 * tryLock()
 * tryLock(long timeout, TimeUnit timeUnit)
 * unlock()
 *
 */
public class MyLockReentrant {

	private boolean isLocked = false;
	private Thread lockingThread = null;
	private int lockCount = 0;

	public synchronized void lock() {
		while (isLocked && Thread.currentThread() != lockingThread) {
			try {
				wait();
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
		isLocked = true;
		lockingThread = Thread.currentThread();
		lockCount++;
	}

	public synchronized void unlock() {
		if (lockingThread == Thread.currentThread()) {
			lockCount--;
			if (lockCount == 0) {
				isLocked = false;
				notifyAll();
			}
		}
	}
}
