package design_pattern.structural;

/*
 * Decorator pattern lets you dynamically change the behavior of an object at run time by wrapping them in an object of a decorator class.
 * Decorator - Attach additional responsibilities to an object dynamically.
 * 
 * Structure
 * interface Component +execute()
 * class ConcreteComponent implements Component
 * 
 * class BaseDecorator extends Component
 *  has Component
 *  +execute
 *  //other methods
 *  
 *  ConcreteDecorator1 extends BaseDecorator
 *   has Component
 *   +execute
 *   //other methods
 *  ConcreteDecorator2 extends BaseDecorator
 *   has Component
 *   +execute
 *   //other methods
 */

interface DataSource {
	void writeData(String data);
}
class FileDataSource implements DataSource {
	String fileName;
	public FileDataSource(String file) {
		fileName = file;
	}
	public void writeData(String data) {
		//Write data to the file
	}
}

abstract class DataSourceDecorator implements DataSource{
	
}

class EncryptionDataSourceDecorator extends DataSourceDecorator {
	private DataSource ds;
	public EncryptionDataSourceDecorator(DataSource ds) {
		this.ds = ds;
	}
	@Override
	public void writeData(String data) {
		String encrypted = data; //instead of data we have to add the encryption logic
		ds.writeData(encrypted);
	}
}
class CompressionDataSourceDecorator extends DataSourceDecorator {
	private DataSource ds;
	public CompressionDataSourceDecorator(DataSource ds) {
		this.ds = ds;
	}
	@Override
	public void writeData(String data) {
		String compressed = data; //instead of data we have to add the compression logic
		ds.writeData(compressed);
	}
}
public class Decorator {
	public static void main(String[] args) {
		//Notice, how we have decorated the filedatasource with encryption datasource and then with compression datasource
		//Similarly we can add behavior dynamically by adding behavior 
		DataSource ds = new CompressionDataSourceDecorator(new EncryptionDataSourceDecorator(new FileDataSource("abc.data")));
		ds.writeData("Hello World!");
	}
}
