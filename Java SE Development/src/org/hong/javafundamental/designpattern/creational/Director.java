package org.hong.javafundamental.designpattern.creational;

public class Director {
	
	private PizzaBuilder pizzaBuilder;
	
	public void setPizzaBuilder(PizzaBuilder pizzaBuilder) {
		this.pizzaBuilder = pizzaBuilder;
	}
	
	public void buildPizza() {
		pizzaBuilder.buildPizza();
		pizzaBuilder.buildDough();
		pizzaBuilder.buildSauce();
		pizzaBuilder.buildTopping();
	}
	
	public Pizza getPizza() {
		return pizzaBuilder.getPizza();
	}

}
