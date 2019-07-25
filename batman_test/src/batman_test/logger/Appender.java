package batman_test.logger;

import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingQueue;

public class Appender extends Thread{
	
	private BlockingQueue<LogRecord> queue = new ArrayBlockingQueue<>(20);
	
	private boolean isRunning;
	
	private LogWriter writer;
	
	public Appender(LogWriter writer) {
		isRunning = true;
		start();
	}
	
	@Override
	public void run()  {
		while(isRunning) {
			try {
				LogRecord record = queue.take();
				writer.write(record);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
		}
	}
	
	public void append(LogRecord l) {
		queue.add(l);
	}
	
	public void kill() {
		isRunning = false;
	}

}
