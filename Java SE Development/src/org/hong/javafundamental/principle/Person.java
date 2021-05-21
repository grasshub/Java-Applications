package org.hong.javafundamental.principle;

import lombok.Data;

@Data
public class Person {

	private String name;
	private int age;

	public Person(String name, int age) {
		this.name = name;
		this.age = age;
	}

	public Person changePerson(Person person) {
		person.setName("Eric");
		person = new Person("John", 33);
		
		return person;
	}
	
}
