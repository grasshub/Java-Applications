package org.hong.javafundamental.platform;

import java.io.IOException;
import java.util.Map;
import java.util.Properties;

public class ProcessBuilderRunner {
	
	// iTunes
	private static final String PROGRAM_NAME = "C:/Program Files/iTunes/iTunes";
	
	public static void main(String[] args) throws IOException {
		
		// Use ProcessBuilder to launch application and print out environment variable
		ProcessBuilder pb = new ProcessBuilder(PROGRAM_NAME);
		Process process = pb.start();
		
		Map<String, String> env = pb.environment();
		for (String envName: env.keySet()) {
			System.out.printf("%s = %s%n", envName, env.get(envName));
		}
		
		System.out.println();
		
		Properties systemProperties = System.getProperties();
		for (Object propertyName: systemProperties.keySet())
			System.out.printf("%s = %s%n", propertyName, systemProperties.get(propertyName));
		
		process.destroy();
	}

}
