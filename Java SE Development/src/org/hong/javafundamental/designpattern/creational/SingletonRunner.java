package org.hong.javafundamental.designpattern.creational;

public class SingletonRunner {
	
	public static void main(String[] args) {
		
		Universe universe = Universe.getInstance();
		//universe = new Universe();
		universe.setName("Universe");
		System.out.println("The name of universe: " + universe.getName());
		
	}

}
