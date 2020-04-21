package main.java.ch.start.uebungen;


import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;


public class LearningLog4J {

	
	public static void main(String[] args) {
		Logger logger = LogManager.getLogger(LearningLog4J.class);
		logger.debug("Debug log message");
        logger.info("Info log message");
        logger.error("Error log message");
        logger.warn("Warning log message");
	}

}
