package org.hong.javafundamental.closure;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Consumer;
import java.util.function.Supplier;
import java.util.logging.Level;
import java.util.logging.Logger;

public class ConsumerSupplier {
	private static final Logger logger = Logger.getLogger(ConsumerSupplier.class.getName());
	
	private static void printName(String name) {
		logger.log(Level.INFO, name);
	}
	
	private static void printNames(Supplier<String> supplier) {
		logger.log(Level.INFO, supplier.get());
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
		
		// Lambda expression returns supplier
		names.forEach(name -> printNames(() -> name));
		
	}
}
