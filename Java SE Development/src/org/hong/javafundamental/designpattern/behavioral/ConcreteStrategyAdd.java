package org.hong.javafundamental.designpattern.behavioral;

public class ConcreteStrategyAdd implements IStrategy {

	public int execute(int a, int b) {
		System.out.println("Calling ConcreteStratgy Add's execute method");
		return a + b;
	}
}
