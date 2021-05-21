package org.hong.javafundamental.jackson2;

import lombok.Data;

import java.math.BigDecimal;
import java.util.List;

@Data
public class Employee {
	
	private String name;
	private int age;
	private String position;
	private BigDecimal salary;
	private List<String> skills;
}
