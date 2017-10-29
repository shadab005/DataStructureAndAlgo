package javaconcepts.threads;

public class MyReEntrantLockImpl {

	private boolean isLocked = false;
	private Thread lockingThread = null;
	int lockCount = 0;

	public synchronized void lock() throws InterruptedException {
      Thread current  = Thread.currentThread();
      while(isLocked && lockingThread!=current) {
    	  wait();
      }
      isLocked = true;
      lockCount++;
      lockingThread = current;
	}

	public synchronized void unlock() {

		if (this.lockingThread != Thread.currentThread()) {
			throw new IllegalMonitorStateException("Calling thread has not locked this lock");
		}
		lockCount--;
		if (lockCount == 0) {
			isLocked = false;
			lockingThread = null;
			notify();
		}
	}
}
