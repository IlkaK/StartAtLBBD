package main.java.ch.start.uebungen;


import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;


public class LearningLog4J {

	
	public static void main(String[] args) {
		Logger logger = LogManager.getLogger(LearningLog4J.class);
		logger.info("Log4J2 application.");
	}

}
