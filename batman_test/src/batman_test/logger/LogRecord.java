package batman_test.logger;

public class LogRecord {
	
	private LogLevel logLevel;
	private String message;
	
	public LogRecord(LogLevel level, String message) {
		setLogLevel(level);
		setMessage(message);
	}

	public LogLevel getLogLevel() {
		return logLevel;
	}

	public void setLogLevel(LogLevel logLevel) {
		this.logLevel = logLevel;
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

}
