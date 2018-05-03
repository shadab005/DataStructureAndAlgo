package module.logger;

public abstract class Handler {

	protected Formatter formatter;
	
	public abstract void publish(LogRecord record);
	
	public void setFormatter(Formatter formatter) {
		this.formatter = formatter;
	}
	
}
