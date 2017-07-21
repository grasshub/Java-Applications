package org.hong.javafundamental.designpattern.creational;

//universe based on singleton pattern
public final class Universe {
	
	//recreated on class loading
	private static final Universe universe = new Universe();
	private String name;
	
	public static Universe getInstance() {
		return universe;
	}
	
	public String getName() {
		return name;
	}
	
	public String setName(String name) {
		return this.name = name;
	}
	
	//private constructor to prevent other class to recreate another instance of this singleton class
	private Universe() {
		
	}
}
