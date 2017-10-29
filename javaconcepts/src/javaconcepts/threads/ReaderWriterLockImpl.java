package javaconcepts.threads;

public class ReaderWriterLockImpl {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}

/*
 * Non Reentrant lock
 */
class ReaderWriterLock {
	int readerCount = 0;
	int writerCount = 0;
	int writeRequestCount = 0;

	synchronized void readLock() throws InterruptedException {
		while (writerCount > 0 || writeRequestCount > 0) { //Allow waiting writer
			wait();
		}
		readerCount++;
	}

	synchronized void readUnLock() {
		readerCount--;
		notifyAll();
	}

	synchronized void writeLock() throws InterruptedException {
		writeRequestCount++;
		while (readerCount > 0 || writerCount>0) {
			wait();
		}
		writeRequestCount--;
		writerCount++;
	}

	synchronized void writeUnLock() {
		writerCount--;
		notifyAll();
	}
}
