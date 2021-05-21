package org.hong.javafundamental.io;

import java.io.Serializable;
import java.util.Calendar;

public class Employee implements Serializable {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1339159769143191807L;
	
	private final String name;
	private final int salary;
	private final Calendar joinDate;
	
	public Employee(String name, int salary, Calendar joinDate) {
		this.name = name;
		this.salary = salary;
		this.joinDate = joinDate;
	}
	
	public String getName() {
		return name;
	}
	
	public int getSalary() {
		return salary;
	}
	
	public Calendar getJoinDate() {
		return joinDate;
	}

}
