package org.hong.javafundamental.closure;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Consumer;
import java.util.function.Supplier;

public class ConsumerSupplier {
	
	private static void printName(String name) {
		System.out.println(name);
	}
	
	private static void printNames(Supplier<String> supplier) {
		System.out.println(supplier.get());
	}

	public static void main(String[] args) {
		Consumer<String> consumer = ConsumerSupplier::printName;
		
		consumer.accept("Paul");
		consumer.accept("John");
		consumer.accept("Richard");
		
		List<String> names = new ArrayList<>();
		names.add("Paul");
		names.add("John");
		names.add("Richard");
		
		// Lambda expression returns suppiler
		names.stream().forEach(name -> printNames(() -> name));
		
	}
}
