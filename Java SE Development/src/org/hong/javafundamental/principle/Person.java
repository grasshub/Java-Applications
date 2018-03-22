package org.hong.javafundamental.principle;

public class Person {
	
	private String name;
	
	Person(String name) {
		this.name = name;
	}
	
	public String getName() {
		return name;
	}
	
	public void setName(String name) {
		this.name = name;
	}
	
	public Person changePerson(Person person) {
		person.setName("Eric");
		person = new Person("John");
		
		return person;
	}
	
}
