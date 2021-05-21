package org.hong.javafundamental.enumeration;

import static org.hong.javafundamental.enumeration.Planet.*;

public class EnumTest {

	public static void main(String[] args) {
		System.out.println("The mass of mercury: " + MERCURY.getMass());
		System.out.println("The radius of mercury: " + MERCURY.getRadius());
		System.out.println("The mass of venus: " + Planet.valueOf("VENUS").getMass());
		System.out.println("The mass of venus: " + Planet.valueOf("VENUS").getRadius());
		
		for (Planet planet : Planet.values()) {
			System.out.printf("The mass of %s is: %.0f%n", planet, planet.getMass());
			System.out.printf("The radius of %s: is: %.0f%n", planet, planet.getRadius());
		}

	}

}
