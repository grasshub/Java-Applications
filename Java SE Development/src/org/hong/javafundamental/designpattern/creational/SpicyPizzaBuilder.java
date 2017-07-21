package org.hong.javafundamental.designpattern.creational;

public class SpicyPizzaBuilder extends PizzaBuilder {
	
	public void buildDough() {
		pizza.setDough("pan baked");
	}

	public void buildSauce() {
		pizza.setSauce("hot");
	}
	
	public void buildTopping() {
		pizza.setTopping("pepperoni and salami");
	}

}
