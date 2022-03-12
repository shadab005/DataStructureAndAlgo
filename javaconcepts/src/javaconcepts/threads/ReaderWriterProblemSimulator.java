package javaconcepts.threads;

public class ReaderWriterProblemSimulator {

	public static void main(String[] args) {

		  final int READERS = 3;
	      final int WRITERS = 2;
	      Database database = new Database();
	      for (int i = 0; i < READERS; i++)
	      {
	        new Reader(database).start();
	      }
	      for (int i = 0; i < WRITERS; i++)
	      {
	        new Writer(database).start();
	      }
	}

}

class Database {
	private int readers; // number of active readers

	public void read(int number) throws InterruptedException {
		synchronized (this) {
			this.readers++;
			System.out.println("Reader " + number + " starts reading.");
		}
		System.out.println("I am reading the database");
		Thread.sleep(2000);
		synchronized (this) {
			System.out.println("Reader " + number + " stops reading.");
			this.readers--;
			if (this.readers == 0) {
				this.notifyAll();
			}
		}
	}

	public synchronized void write(int number) throws InterruptedException {
		while (this.readers != 0) {
			this.wait();
		}
		System.out.println("Writer " + number + " starts writing.");
		Thread.sleep(2000);
		System.out.println("Writer " + number + " stops writing.");
		this.notifyAll();
	}
}

class Reader extends Thread {
	private static int readers = 0; // number of readers
	private int number;
	private Database database;

	public Reader(Database database) {
		this.database = database;
		this.number = Reader.readers++;
	}

	@Override
	public void run() {
		while (true) {
			final int DELAY = 5000;
			try {
				Thread.sleep((int) (Math.random() * DELAY));
			} catch (InterruptedException e) {
			}
			try {
				this.database.read(this.number);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
	}
}

class Writer extends Thread {
	private static int writers = 0; // number of writers
	private int number;
	private Database database;

	public Writer(Database database) {
		this.database = database;
		this.number = Writer.writers++;
	}

	@Override
	public void run() {
		while (true) {
			final int DELAY = 5000;
			try {
				Thread.sleep((int) (Math.random() * DELAY));
			} catch (InterruptedException e) {
			}
			try {
				this.database.write(this.number);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
	}
}