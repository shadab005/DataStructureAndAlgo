package module.logger;

public class TestLogger {

	public static void main(String[] args) {
		test1();

	}

	private static void test1() {
		//setup of logger
		//this should be the only setup from client ide
		Logger LOGGER = Logger.getLogger(TestLogger.class.getName());
		
		//needs another handling
		Handler h1 = new ConsoleHandler();
		h1.setFormatter(new SimpleFormatter());
		
		
		LOGGER.info("hi");
		
		System.out.println("zzzzzzzzzzzz");
		
		LOGGER.info("done");
		
	}

}
