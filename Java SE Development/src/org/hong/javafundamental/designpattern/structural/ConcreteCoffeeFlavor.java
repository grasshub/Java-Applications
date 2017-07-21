package org.hong.javafundamental.designpattern.structural;

public final class ConcreteCoffeeFlavor implements CoffeeFlavor {
	
	private final String name;
	
	public ConcreteCoffeeFlavor(String name) {
		this.name = name;
	}

	public String getFlavor() {
		return name;
	}
	
	public void serveCoffee(CoffeeOrderContext context) {
		System.out.printf("Serving coffee flavor: %s to table number: %d%n", name, context.getTable());
	}
	
}
