package batman_test.logger;

import java.io.File;

public class FileAppender implements Appender{

	private File file;
	
	public FileAppender(String fileName) {
		file = new File(fileName);
	}
	
	@Override
	public void append(LogRecord record) {
		// TODO Auto-generated method stub
		
	}

}
