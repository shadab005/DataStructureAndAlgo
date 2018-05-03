package module.logger;

public class Logger {

	private Level level;
	
	private String name;
	
	Appender appender;
	
	private Logger(String name) {
		this.name = name;
		level = Level.INFO;
	}
	
	
	public void info(String msg) {
		log(Level.INFO, msg);
	}
	
	public void debug(String msg) {
		log(Level.DEBUG, msg);
	}
	
	public void error(String msg) {
		log(Level.ERROR, msg);
	}
	
	public void log(Level level, String msg) {
		if(!canBeLogged(level))return;
		LogRecord lr = new LogRecord(level, msg);
		lr.setLoggerName(name);
		log(lr);
	}
	
	public void log(LogRecord log) {
		/*for(Handler h: handlers) {
			h.publish(log);
		}*/
		appender.appendLogRecord(log);
	}
	
	private boolean canBeLogged(Level level) {
		if(level.lessThan(this.level))return false;
		return true;
	}
	
	
	public String getName() {
		return name;
	}
	public static Logger getLogger(String loggerName) {
		return new Logger(loggerName);
	}
	
}
