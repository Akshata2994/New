package Log4j;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class Log4jDemo {
	
	static Logger logger = LogManager.getLogger(Log4jDemo.class);

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		System.out.println("\n Hello World!!!!!!!!!!!!!!  \n");
		
		logger.trace("This is trace Message");
		logger.debug("This is debug Message");
		logger.info("This is information Message");
		logger.warn("This is warning message");
		logger.error("This is error message");
		logger.fatal("This is fatal message");
		
		System.out.println("\n completed\n");
		
	}

}
