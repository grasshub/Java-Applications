package org.hong.javafundamental.designpattern.creational;

import java.io.*;

public class FactoryRunner {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		/*
		//sadly, console is not supported by Eclipse
		Console console = System.console();
		if (console == null) {
	         System.err.println("No console.");
	         System.exit(1);
	    }
		String name = console.readLine("Please enter a name: ");
		*/

		// read from System.in at Eclipse
		String name = null;
		BufferedReader bufferedReader = null;
		System.out.println("Please enter a name:");

		try {
			bufferedReader = new BufferedReader(new InputStreamReader(System.in));
			name = bufferedReader.readLine();
		} catch (IOException ex) {
			System.out.println("Could not read a name from console");
		}
		finally {
			if (bufferedReader != null)
				try{				
					bufferedReader.close();
				} catch (IOException ex) {
					System.out.println("Could not close the buffered read for system.in");
				}
		}

		if (name != null) {
			Name concreteName = NameFactory.getName(name);
			System.out.println("The Last name: " + concreteName.getLastName() + " The first name: " + concreteName.getFirstName());
		}
		else
			System.out.println("The name is not available");
	}

}
