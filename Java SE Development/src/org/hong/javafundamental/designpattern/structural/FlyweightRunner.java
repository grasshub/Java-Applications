package org.hong.javafundamental.designpattern.structural;

public class FlyweightRunner {
	
	private static void takeCoffeeOrder(String flavorName, int tableNumber) {
		CoffeeFlavor coffeeFlavor = CoffeeFlavorFactory.getCoffeeFlavor(flavorName);
		coffeeFlavor.serveCoffee(new CoffeeOrderContext(tableNumber));
	}
	
	public static void main(String[] args) {
		
		takeCoffeeOrder("Cappuccino", 2);
		takeCoffeeOrder("Cappuccino", 2);
		takeCoffeeOrder("Frappe", 1);
		takeCoffeeOrder("Xpresso", 4);
		takeCoffeeOrder("Hot Coco", 9);
		takeCoffeeOrder("Hot Chocolate", 2);
		
		System.out.println("Total coffee flavors served: " + CoffeeFlavorFactory.getTotalCoffeeFlavors());
		
	}

}
