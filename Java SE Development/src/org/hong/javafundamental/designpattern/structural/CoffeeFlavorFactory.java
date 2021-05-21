package org.hong.javafundamental.designpattern.structural;

import java.util.HashMap;
import java.util.Map;

public class CoffeeFlavorFactory {
	
	private static final Map<String, CoffeeFlavor> coffeeFlavors = new HashMap<>();

	private CoffeeFlavorFactory() {}
	
	public static CoffeeFlavor getCoffeeFlavor(String flavorName) {
		return coffeeFlavors.get(flavorName) == null?
				coffeeFlavors.putIfAbsent(flavorName, new ConcreteCoffeeFlavor(flavorName))
				: coffeeFlavors.get(flavorName);
	}

	public static int getTotalCoffeeFlavors() {
		return coffeeFlavors.size();
	}
}
