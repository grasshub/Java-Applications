package org.hong.javafundamental.designpattern.behavioral;

import java.util.Map;

public class Number implements Expression {
	
	private final int number;
	
	public Number(int number) {
		this.number = number;
	}
	
	public int interpret(Map<String, Expression> context) {
		return number;
	}

}
