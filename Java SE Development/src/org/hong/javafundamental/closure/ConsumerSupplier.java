package org.hong.javafundamental.closure;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Consumer;
import java.util.function.Supplier;
import java.util.logging.Level;
import java.util.logging.Logger;

public class ConsumerSupplier {
	private static final Logger logger = Logger.getLogger(ConsumerSupplier.class.getName());

	private static void printNames(Supplier<String> supplier) {
		logger.log(Level.INFO, supplier.get());
	}

	public static void main(String[] args) {
		// Consumer to modify the list.
		Consumer<List<Integer>> modifyList = list -> {
			for (int i = 0; i < list.size(); i++) {
				list.set(i, list.get(i) * 2);
			}
		};

		Consumer<List<Integer>> displayList = list -> list.forEach(x -> logger.log(Level.INFO, x.toString()));

		List<Integer> integers = new ArrayList<>();
		integers.add(1);
		integers.add(2);
		integers.add(3);

		modifyList.andThen(displayList).accept(integers);

		// Consumer to print out name.
		Consumer<String> display = x -> logger.log(Level.INFO, x);

		display.accept("Paul");
		display.accept("John");
		display.accept("Richard");
		
		List<String> names = new ArrayList<>();
		names.add("Paul");
		names.add("John");
		names.add("Richard");
		
		// Lambda expression returns supplier
		names.forEach(name -> printNames(() -> name));
	}
}
