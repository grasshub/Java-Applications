package org.hong.javafundamental.designpattern.behavioral;

import java.util.HashMap;
import java.util.Map;

public class InterpretRunner {
	
	public static void main(String[] args) {
		//interprets the expression "10 w x z - + +" in reverse polish notation
		String expression = "10 w x z - + +";
		Parser parser = new Parser(expression);
		Map<String, Expression> context = new HashMap<String, Expression>();
		
		context.put("w", new Number(5));
		context.put("x", new Number(10));
		context.put("z", new Number(25));
		
		int result = parser.interpret(context);
		System.out.println("The result of interpreting expression is: " + result);
		
	}

}
