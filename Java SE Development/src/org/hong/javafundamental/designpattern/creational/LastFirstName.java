package org.hong.javafundamental.designpattern.creational;

public class LastFirstName extends Name {
	
	//split a string into last and first name, last and first name is split by comma
	public LastFirstName(String name) {
		
		int nameIndex = name.indexOf(",");
		if (nameIndex > 0) {
			lastName = name.substring(0, nameIndex).trim();
			firstName = name.substring(nameIndex +1).trim();
		}
		else {
			// only first name entered
			if (nameIndex == 0) {
				firstName = name.trim();
				lastName = "";
			}
			else {
				lastName = name.trim();
				//firstName is empty
				firstName = "";
			}
		}
	}

}
