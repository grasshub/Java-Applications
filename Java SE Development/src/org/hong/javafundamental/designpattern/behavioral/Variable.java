package org.hong.javafundamental.designpattern.behavioral;

import java.util.Map;

public class Variable implements Expression {
	
	private final String name;
	
	public Variable(String name) {
		this.name = name;
	}
	
	public int interpret(Map<String, Expression> context) {
		if (context.get(name) == null)
			return 0;
		else
			return context.get(name).interpret(context);
	}

}
