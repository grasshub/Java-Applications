package org.hong.javafundamental.designpattern.creational;

public class NameFactory {
	//return an instance of Name (either LastFirstName or FirstLastName) based on
	//the comma found at input string
	private NameFactory() {}
	
	public static Name getName(String name) {
		int nameIndex = name.indexOf(",");
		
		if (nameIndex >0) 
			return new LastFirstName(name);
		else
			return new FirstLastName(name);
		
	}

}
