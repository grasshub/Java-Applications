package org.hong.javafundamental.designpattern.structural;

import java.util.List;

public class Adapter implements IAdapter {

	private final Adaptee adaptee = new Adaptee();
	
	public void printList(List<String> stringList) {
		
		StringBuilder tempString = new StringBuilder();
		
		for (String string: stringList) {
			tempString.append(string).append("\n");
		}
		
		adaptee.printString(tempString.toString());
		
	}
}
