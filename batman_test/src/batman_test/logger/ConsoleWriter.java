package batman_test.logger;

public class ConsoleWriter implements LogWriter{
	@Override
	public void write(LogRecord record) {
		System.out.println(record);
	}

}
