package org.hong.javafundamental.designpattern.behavioral;

import java.util.ArrayDeque;

import java.util.Arrays;
import java.util.Deque;
import java.util.List;
import java.util.Map;

public class Parser implements Expression {
	
	private final Expression syntaxTree;
	
	public Parser(String expression) {
		Deque<Expression> expressionStack = new ArrayDeque<>();
		List<String> variableList = Arrays.asList("a", "b", "c", "d", "e", "f", "g", "h", "i", "j", "k", "l", "m", "n", "o", "p", "q", "r", "s", "t", "u", "v", "w", "x", "y", "z");
		//spit input token on empty space
		for (String token : expression.split(" ")) {
			if (token.equals("+")) {
				Expression subExpression = new Plus(expressionStack.pop(), expressionStack.pop());
				expressionStack.push(subExpression);
			}
			else if (token.equals("-")) {
				//it's necessary pop up first the right operand
				Expression rightOperand = expressionStack.pop();
				Expression leftOperand = expressionStack.pop();
				Expression subExpression = new Minus(leftOperand, rightOperand);
				expressionStack.push(subExpression);
			}
			else if (variableList.contains(token)) {
				expressionStack.push(new Variable(token));
			}
			else
				expressionStack.push(new Number(Integer.parseInt(token)));			
		}
		//the stack only contains a single composite element with type as either Plus or Minus. 
		syntaxTree = expressionStack.pop();		
	}
	
	public int interpret(Map<String, Expression> context) {
		return syntaxTree.interpret(context);
	}

}
