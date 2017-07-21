package org.hong.javafundamental.designpattern.creational;

public class FirstLastName extends Name {
	
	//split a string into first and last name, first and last name is split by empty space
	public FirstLastName(String name) {
		
		int nameIndex = name.indexOf(" ");
		if (nameIndex > 0) {
			firstName = name.substring(0, nameIndex);
			lastName = name.substring(nameIndex +1).trim();
		}
		else {
			// only last name entered
			if (nameIndex == 0) {
				lastName = name.trim();
				firstName = "";
			}
			else {
				firstName = name;
				//lastName is empty
				lastName = "";
			}
		}
	}

}
