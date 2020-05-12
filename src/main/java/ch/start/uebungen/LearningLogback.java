package ch.start.uebungen;

import org.slf4j.LoggerFactory;
import org.slf4j.Logger;


public class LearningLogback {

	final static Logger logger = LoggerFactory.getLogger(LearningLogback.class);
	
	public static void main(String[] args) {
		logger.info("Logback application.");
	}

}
