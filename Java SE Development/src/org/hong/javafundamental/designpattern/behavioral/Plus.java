package org.hong.javafundamental.designpattern.behavioral;

import java.util.Map;

public class Plus implements Expression {
	
	private Expression leftOperand;
	private Expression rightOperand;
	
	public  Plus(Expression leftOperand, Expression rightOperand) {
		this.leftOperand = leftOperand;
		this.rightOperand = rightOperand;
	}
	
	public int interpret(Map<String, Expression> context) {
		return leftOperand.interpret(context) + rightOperand.interpret(context);
	}
}
