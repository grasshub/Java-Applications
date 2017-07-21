package org.hong.javafundamental.designpattern.behavioral;

public class Context {
	
	private IStrategy strategy;
	
	public void setStrategy(IStrategy strategy) {
		this.strategy = strategy;
	}
	
	public int executeStrategy(int a, int b) {
		return strategy.execute(a, b);
	}
}
