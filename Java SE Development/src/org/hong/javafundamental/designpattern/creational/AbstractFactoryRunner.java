package org.hong.javafundamental.designpattern.creational;

import java.io.IOException;

import org.hong.javafundamental.util.PropertiesUtils;

public class AbstractFactoryRunner {
	
	private static final String OS_NAME = "os.name";
	private static final String WINDOWS = "Windows";
	private static final String MAC = "Mac";

	/* why could not return the subtype for GUIFactory??
	public static GUIFactory createOsSpecificFactory() {
		if (OsUtils.isWindows()) 
			return new WinFactory();
		else if (OsUtils.isMac())
			return new OSXFactory();
	}
	*/
	
	/**
	 * @param args
	 * @throws IOException 
	 */
	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		GUIFactory factory = null;
		
		/*
		if (OsUtils.isWindows()) 
			factory = new WinFactory();
		else if (OsUtils.isMac())
			factory = new OSXFactory();
		*/
		
		String osName = PropertiesUtils.getProperty(OS_NAME);
		
		if (osName.equalsIgnoreCase(WINDOWS)) 
			factory = new WinFactory();
		else if (osName.equalsIgnoreCase(MAC))
			factory = new OSXFactory();
		
		new Application(factory);
		
		new Application(new DAOFactoryOracle());
		//new Application(new DAOFactorySybase());
	}

}
