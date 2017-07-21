package org.hong.javafundamental.designpattern.creational;

public class User {
	
	private String name;
	
	public User(String name) {
		this.name = name;
	}
	
	public String getName() {
		return name;
	}
	
	public String setName(String name) {
		return this.name = name;
	}

}
