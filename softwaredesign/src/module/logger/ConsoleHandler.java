package module.logger;

public class ConsoleHandler extends Handler {

	@Override
	public void publish(LogRecord record) {
		System.out.println(formatter.format(record));
	}

}
