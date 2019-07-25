package batman_test.logger;

public class ConsoleAppender implements Appender{
	@Override
	public void append(LogRecord record) {
		System.out.println(record);
	}

}
