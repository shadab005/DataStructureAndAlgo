package javaconcepts.threads.lock;

import java.util.Collection;
import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.LinkedTransferQueue;
import java.util.concurrent.locks.ReadWriteLock;
import java.util.concurrent.locks.ReentrantReadWriteLock;

public class TestClient {

	public static void main(String[] args) {
		testSimpleLock();
		ReadWriteLock readWriteLock = new ReentrantReadWriteLock();
		LinkedTransferQueue<String> lnkTransQueue = new LinkedTransferQueue<String>();
		ArrayBlockingQueue<String> s;
		Collection c;
		

	}

	private static void testSimpleLock() {
		
		
	}

}
