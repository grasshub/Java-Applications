package org.hong.javafundamental.designpattern.creational;

public class HawaiianPizzaBuilder extends PizzaBuilder {
	
	public void buildDough() {
		pizza.setDough("cross");
	}

	public void buildSauce() {
		pizza.setSauce("mild");
	}
	
	public void buildTopping() {
		pizza.setTopping("ham and pineapple");
	}
}
