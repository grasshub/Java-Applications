package org.hong.javafundamental.generics;

import java.util.*;

public class HeapPollutionExample {

// Only available at Java SE 7.0	
//	@SafeVarargs
	@SuppressWarnings("unchecked")
	public static void main(String[] args) {

		List<String> stringListA = new ArrayList<String>();
		List<String> stringListB = new ArrayList<String>();

		ArrayBuilder.addToList(stringListA, "Seven", "Eight", "Nine");
		ArrayBuilder.addToList(stringListA, "Ten", "Eleven", "Twelve");
		List<List<String>> listOfStringLists =
			new ArrayList<List<String>>();
		ArrayBuilder.addToList(listOfStringLists, stringListA, stringListB);

		ArrayBuilder.faultyMethod(Arrays.asList("Hello!"), Arrays.asList("World!"));
	}
}
