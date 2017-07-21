package org.hong.javafundamental.designpattern.creational;

public enum Singleton {
	
	INSTANCE;
	
	private String name;
	
	public String getName() {
		return name;
	}
	
	public void setName(String name) {
		this.name = name;
	}
	
	public void execute(String arg) {
		System.out.println("Executing method " + arg);
	}
	
}
