package batman_test.logger;

public class Logger {
	
	private LogLevel logLevel;

	private Appender appender;
	
	public Logger() {
		logLevel = LogLevel.INFO;
		appender = new Appender(new ConsoleWriter());
	}
	
	public Logger(LogLevel logLevel, LogWriter writer) {
		this.logLevel = logLevel;
		appender = new Appender(writer);
		
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
    
    public void log(LogRecord logRecord) {
		if(canBeLogged(logRecord)) {
			appender.append(logRecord);
		}
	}

	private boolean canBeLogged(LogRecord logRecord) {
		return logLevel.isLessPriority(logRecord.getLogLevel());
	}

	public LogLevel getLogLevel() {
		return logLevel;
	}

	public void setLogLevel(LogLevel logLevel) {
		this.logLevel = logLevel;
	}

}
