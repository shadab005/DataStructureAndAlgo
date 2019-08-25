package module.logger;

public class Test {

	public static void main(String[] args) {
		Logger logger = LoggerFactory.getLogger(Test.class.getName());
		logger.logInfo("Hello logger");
	}
}
