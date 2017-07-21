package org.hong.javafundamental.designpattern.creational;

public class BuilderRunner {
	
	public static void main(String[] args) {
		Director director = new Director();
		
		PizzaBuilder pizzaBuilder = new HawaiianPizzaBuilder();
		director.setPizzaBuilder(pizzaBuilder);
		director.buildPizza();
		
		Pizza pizza = director.getPizza();
		System.out.printf("The pizza dough is: %s, sauce is: %s, topping is: %s%n", pizza.getDough(), pizza.getSauce(), pizza.getTopping());
		
		pizzaBuilder = new SpicyPizzaBuilder();
		director.setPizzaBuilder(pizzaBuilder);
		director.buildPizza();
		
		pizza = director.getPizza();
		System.out.printf("The pizza dough is: %s, sauce is: %s, topping is: %s%n", pizza.getDough(), pizza.getSauce(), pizza.getTopping());
		
	}

}
