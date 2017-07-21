package org.hong.javafundamental.designpattern.behavioral;

public class ConcreteStrategyMultiply implements IStrategy {
	
	public int execute(int a, int b) {
		System.out.println("Calling ConcreteStratgyMultiple's execute method");
		return a * b;
	}

}
