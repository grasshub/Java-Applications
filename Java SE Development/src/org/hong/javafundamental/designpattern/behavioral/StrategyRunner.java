package org.hong.javafundamental.designpattern.behavioral;

public class StrategyRunner {
	
	public static void main(String[] args) {
		
		Context context;
		
		//Three contexts using different strategies
		context = new Context();
		
		context.setStrategy(new ConcreteStrategyAdd());
		int firstResult = context.executeStrategy(3, 4);
		
		context.setStrategy(new ConcreteStrategySubtract());
		int secondResult = context.executeStrategy(3, 4);
		
		context.setStrategy(new ConcreteStrategyMultiply());
		int thirdResult = context.executeStrategy(3, 4);
		
		System.out.println("The first result: " + firstResult);
		System.out.println("The first result: " + secondResult);
		System.out.println("The first result: " + thirdResult);
		
	}
}
