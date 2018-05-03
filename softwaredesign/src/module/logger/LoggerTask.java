package module.logger;

public class LoggerTask implements Runnable {
	boolean isActive;
	
	Appender appender;
	
	public LoggerTask(Appender appender) {
		this.appender = appender;
	}
	
	

	@Override
	public void run() {
		while(isActive) {
			LogRecord record = appender.getLogRecord();
			for(Handler hander:appender.getHandlers()) {
				
			}
		}
		
	}

}
