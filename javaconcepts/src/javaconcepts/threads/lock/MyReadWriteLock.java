package javaconcepts.threads.lock;

/*
 * Strong writer priority
 *  non reentrant.
 */
public class MyReadWriteLock {

	private int reader = 0;
	private int writer = 0;
	private int writeRequest = 0;

	public synchronized void readLock() throws InterruptedException {
		while (writeRequest > 0 || writer > 0) {
			wait();
		}
		reader++;
	}

	public synchronized void readUnlock() {
		if (reader > 0) {
			reader--;
			if (reader == 0)notifyAll();
		}
	}

	public synchronized void writeLock() throws InterruptedException {
		writeRequest++;
		while (writer > 0 || reader > 0) {
				wait();
		}
		writeRequest--;
		writer++;
	}

	public synchronized void writeUnlock() {
		if (writer > 0) {
			writer--;
			notifyAll();
		}

	}

}
