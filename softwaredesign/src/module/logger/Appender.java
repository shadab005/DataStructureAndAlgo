package module.logger;

import java.util.List;
import java.util.concurrent.BlockingQueue;

public class Appender {

	private List<Handler> handlers;
	BlockingQueue<LogRecord> queue;
	
	public void appendLogRecord(LogRecord logRecord) {
		queue.add(logRecord);
		
	}

	public LogRecord getLogRecord() {
		// TODO Auto-generated method stub
		return null;
	}

	public List<Handler> getHandlers() {
		// TODO Auto-generated method stub
		return null;
	}
	
	

}
