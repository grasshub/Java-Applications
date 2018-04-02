package org.hong.javafundamental.principle;

public class Person {
	
	private String name;
	private int age;
	
	public Person(String name, int age) {
		this.name = name;
		this.age = age;
	}
	
	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}

	public String getName() {
		return name;
	}
	
	public void setName(String name) {
		this.name = name;
	}
	
	public String toString() {
		return name + ", " + age;
	}
	
	public Person changePerson(Person person) {
		person.setName("Eric");
		person = new Person("John", 33);
		
		return person;
	}
	
}
