package batman_test.logger;

import java.io.File;

public class LogFileWriter implements LogWriter{

	private File file;
	
	public LogFileWriter(String fileName) {
		file = new File(fileName);
	}
	
	@Override
	public void write(LogRecord record) {
		// TODO Auto-generated method stub
		
	}

}
