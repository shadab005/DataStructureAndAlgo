package batman_test.logger;

import java.util.List;
import java.util.Map;
import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingQueue;

public class LogHandler extends Thread{
	
	private BlockingQueue<LogRecord> queue = new ArrayBlockingQueue<>(20);
	
	Map<LogLevel, List<Appender>> appenderListForLogLevelMap;
	
	private boolean isRunning;
	
	public LogHandler(Map<LogLevel, List<Appender>> appenderListForLogLevelMap) {
		this.appenderListForLogLevelMap = appenderListForLogLevelMap;
		isRunning = true;
		start();
	}
	
	@Override
	public void run()  {
		while(isRunning) {
			try {
				LogRecord record = queue.take();
				appenderListForLogLevelMap.get(record.getLogLevel()).forEach(a->a.append(record));
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
		}
	}
	
	public void handle(LogRecord l) {
		queue.add(l);
	}
	
	public void kill() {
		isRunning = false;
	}

}
