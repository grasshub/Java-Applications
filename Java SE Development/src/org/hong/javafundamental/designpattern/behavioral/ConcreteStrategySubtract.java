package org.hong.javafundamental.designpattern.behavioral;

public class ConcreteStrategySubtract implements IStrategy {
	
	public int execute(int a, int b) {
		System.out.println("Calling ConcreteStratgySubtract's execute method");
		return a - b;
	}
}
