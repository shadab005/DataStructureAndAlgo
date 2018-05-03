package module.logger;

public class SimpleFormatter implements Formatter {

	@Override
	public String format(LogRecord record) {
		return record.getMillis()+"#"+record.getThreadId()+"#"+record.getSequenceNumber()+
		"#"+record.getLoggerName()+"#"+record.getMessage();
	}

}
