package module.logger;

public class Logger {
	
	private LogLevel logLevel;

	private LogHandler handler;
	
	public Logger(LogLevel logLevel, LogHandler handler) {
		this.logLevel = logLevel;
		this.handler = handler;
	}
	
	public void logInfo(String message) {
		log(new LogRecord(LogLevel.INFO, message));
	}
	
    public void logDebug(String message) {
    	log(new LogRecord(LogLevel.DEBUG, message));
	}
    
    public void logError(String message) {
    	log(new LogRecord(LogLevel.ERROR, message));
	}
    
    public void log(LogLevel level, String message) {
    	log(new LogRecord(level, message));
	}
    
    private void log(LogRecord logRecord) {
		if(canBeLogged(logRecord)) {
			handler.handle(logRecord);
		}
	}

	private boolean canBeLogged(LogRecord logRecord) {
		return logLevel.isMorePriority(logRecord.getLogLevel());
	}

	public LogLevel getLogLevel() {
		return logLevel;
	}

	public void setLogLevel(LogLevel logLevel) {
		this.logLevel = logLevel;
	}

}
