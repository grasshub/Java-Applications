package org.hong.javafundamental.designpattern.creational;

public abstract class PizzaBuilder {
	
	protected Pizza pizza;
	
	public void buildPizza() {
		pizza = new Pizza();
	}
	
	public Pizza getPizza() {
		return pizza;
	}
	
	public abstract void buildDough();
	public abstract void buildSauce();
	public abstract void buildTopping();

}
