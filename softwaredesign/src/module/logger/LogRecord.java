package module.logger;

import java.util.concurrent.atomic.AtomicLong;

public class LogRecord {

	private static final AtomicLong globalSequenceNumber = new AtomicLong(0);
	private Level level;
	private String message;
	private String threadId;
	private String loggerName;
	private long millis;
	private long sequenceNumber;
	
	public LogRecord(Level level, String msg) {
	   	Thread t = Thread.currentThread();
		this.threadId = t.getName()+"-"+t.getId();
		this.level = level;
		this.message = msg;
		this.millis = System.currentTimeMillis();
		sequenceNumber = globalSequenceNumber.getAndIncrement();
	}
	
	public Level getLevel() {
		return level;
	}
	public String getThreadId() {
		return threadId;
	}
	public String getMessage() {
		return message;
	}
	public String getLoggerName() {
		return loggerName;
	}
	public long getMillis() {
		return millis;
	}
	public long getSequenceNumber() {
		return sequenceNumber;
	}
	
	public void setLoggerName(String name) {
		loggerName = name;
	}


}
