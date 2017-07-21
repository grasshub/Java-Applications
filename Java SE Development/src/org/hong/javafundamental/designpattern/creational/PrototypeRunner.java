package org.hong.javafundamental.designpattern.creational;

public class PrototypeRunner {

	/**
	 * @param args
	 * @throws CloneNotSupportedException 
	 */
	public static void main(String[] args) throws CloneNotSupportedException {
		
		Prototype p = new PrototypeImpl(10);
		
		for (int i = 1; i < 10; i++) {
			// Create a defensive copy of object to allow safe manipulation
			Prototype tempData = p.clone();
			
			//Derive a new value from prototype's value
			tempData.setIntValue(tempData.getIntValue() * i);
			System.out.println(tempData.getIntValue());
		}
		
		System.out.println(p.getIntValue());

	}

}
