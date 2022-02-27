package org.hong.javafundamental.platform;

import java.io.IOException;
import java.util.Map;
import java.util.Properties;
import java.util.logging.Logger;

public class ProcessBuilderRunner {
	static Logger logger = Logger.getLogger(ProcessBuilderRunner.class.getName());
	
	public static void main(String[] args) throws IOException {
		
		// Use ProcessBuilder to launch application and print out environment variable
		ProcessBuilder pb = new ProcessBuilder("java", "-version");
		Process process = pb.start();
		
		Map<String, String> env = pb.environment();
		for (Map.Entry<String, String> envEntry: env.entrySet()) {
			logger.info(envEntry.getKey() + " = " + envEntry.getValue());
		}
		
		Properties systemProperties = System.getProperties();
		for (Map.Entry<Object, Object> propertyName: systemProperties.entrySet())
			logger.info(propertyName.getKey() + " = " + propertyName.getValue());
		
		process.destroy();
	}

}
