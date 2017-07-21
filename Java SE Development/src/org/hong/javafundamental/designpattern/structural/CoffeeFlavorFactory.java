package org.hong.javafundamental.designpattern.structural;

import java.util.HashMap;
import java.util.Map;

public class CoffeeFlavorFactory {
	
	private static Map<String, CoffeeFlavor> coffeeFlavors = new HashMap<String, CoffeeFlavor>();
	
	public static CoffeeFlavor getCoffeeFlavor(String flavorName) {
		CoffeeFlavor coffeeFlavor = coffeeFlavors.get(flavorName);
		
		if (coffeeFlavor == null) {
			coffeeFlavor = new ConcreteCoffeeFlavor(flavorName);
			coffeeFlavors.put(flavorName,coffeeFlavor);
		}
		return coffeeFlavor;
	}

	public static int getTotalCoffeeFlavors() {
		return coffeeFlavors.size();
	}
}
