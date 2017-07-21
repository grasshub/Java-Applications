package org.hong.javafundamental.designpattern.structural;

import java.util.List;

public class Adapter implements IAdapter {

	private Adaptee adaptee = new Adaptee();
	
	public void printList(List<String> stringList) {
		
		String tempString = ""; 
		
		for (String string: stringList) {
			tempString = tempString + string + "\n";
		}
		
		adaptee.printString(tempString);
		
	}
}
