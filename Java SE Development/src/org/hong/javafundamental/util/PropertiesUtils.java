package org.hong.javafundamental.util;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Properties;

public class PropertiesUtils {
	
	private static final String DEFAULT_PROPERTIES = "Properties File/default.properties";
	private static final String APPLICATION_PROPERTIES = "Properties File/application.properties";
	// Indicates if both properties files are already loaded
	private static boolean loaded = false;
	private static Properties defaultProperties = null;
	private static Properties applicationProperties = null;
	
	private static void loadProperties() throws IOException {
		
		//load both default and application properties file
		FileInputStream in = null;
		FileInputStream inStream = null;

		try {
			defaultProperties = new Properties();
			in = new FileInputStream(DEFAULT_PROPERTIES);
			defaultProperties.load(in);

			applicationProperties = new Properties(defaultProperties);
			inStream = new FileInputStream(APPLICATION_PROPERTIES);
			applicationProperties.load(inStream);			
		} finally {
			if (in != null)
				in.close();

			if (inStream != null)
				inStream.close();
		}	

		loaded = true;
	}
	
	public static String getProperty(String propertyName) throws IOException {		
		if (!loaded)
			loadProperties();
		
		return applicationProperties.getProperty(propertyName);
	}
	
	public static void setProperty(String propertyName, String propertyValue) throws IOException {		
		if (!loaded)
			loadProperties();
		
		applicationProperties.setProperty(propertyName, propertyValue);
	}
	
	public static void store() throws IOException {
		
		FileOutputStream out = new FileOutputStream(APPLICATION_PROPERTIES);
		applicationProperties.store(out, "");
		if (out != null)
			out.close();
	}

}
