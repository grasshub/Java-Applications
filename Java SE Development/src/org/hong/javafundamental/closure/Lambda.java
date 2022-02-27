package org.hong.javafundamental.closure;

<<<<<<< HEAD
import java.util.*;
=======
import org.hong.javafundamental.principle.Person;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
>>>>>>> 6be4e3049d0fa6b6a55515a142a2cc90f94c3049
import java.util.concurrent.Callable;
import java.util.function.Predicate;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.stream.Stream;

public class Lambda {
<<<<<<< HEAD
	
	// Use the strategy pattern with selector.
	private static int total(List<Integer> integers, 
		Predicate<Integer> selector) {
		return integers.stream()
					   .filter(selector)
					   .mapToInt(e -> 2 * e)
					   .sum();
	}
	
	private static boolean isEven(int integer) {
		System.out.println("isEven for integer: " + integer);
		return integer % 2 == 0;
	}
	
	private static boolean isGT3(int integer) {
		System.out.println("isGT3 for integer: " + integer);
		return integer > 3;
	}
	
	private static int doubleIt(int integer) {
		System.out.println("doubleIt for integer: " + integer);
		return integer * 2;
	}
	
	public static boolean isPrime(int number) {
		return number > 1 && 
			IntStream.range(2, number)
					 .noneMatch(i -> number % i == 0);
	}
	
	public static List<Double> sqrtOfFirst100Primes() {
		// collect method use Collectors to accumulating elements into 
		// collections, summarizing elements.
		
		// All the methods except the last one is intermediate methods that do
		// accumulation, the last one is terminal method, until the terminal
		// method is called, all the intermediate methods will be invoked.
		// Otherwise, due to laziness of invocation, they will not be called.
		return Stream.iterate(2, e -> e + 1)
				.filter(Lambda::isPrime)
				.map(Math::sqrt)
				.limit(100)
				.collect(Collectors.toList());
	}
	
	private static void printSorted(List<Person> people, 
		Comparator<Person> comparator) {
		// Print the sorted list without change the original list
		people.stream()
			  .sorted(comparator)
			  .forEach(System.out::println);
	}
	
	public static void main(String[] args) {
		List<Integer> integers = Arrays.asList(1, 2, 3, 4, 5, 6, 7, 8, 9, 10);
		
		integers.forEach(value -> System.out.println(value));
		// Method reference when method takes the arguments form previous method 
		// call passed in as pipelined.
		integers.forEach(System.out::println);

		// Stream is a sequential used to perform aggregate actions on it.
		Optional<Integer> sumOfSquare = integers.stream()
				.map(e -> e * e)
				.reduce(Integer::sum);

		System.out.println(sumOfSquare.isPresent()
				? sumOfSquare.get() : "Sum of square for list of integer doesn't exist!"
		);
		
		System.out.println(total(integers, e -> true));
		// Predicate for all even integer
		System.out.println(total(integers, e -> e % 2 == 0));
		// Predicate for all odd integer
		System.out.println(total(integers, e -> e % 2 != 0));

		System.out.println(sqrtOfFirst100Primes());
		
		// Stream is lazy (For all the actions)
		// All the intermediate actions will only be performed if necessary.
		// Or could call it efficient.
		// See the print out for the following statement.
		// Fundamental shift: from imperative to functional style.
		// Stream removes the mutability of existing objects, just construct
		// the new objects based on needs.
		System.out.println(
				integers.stream()
				.filter(Lambda::isGT3)
				.filter(Lambda::isEven)
				.map(Lambda::doubleIt)
				.findFirst()
				.orElse(0)
		);
		
		// For time consuming processing, just switch stream to parallelStream
		// to take advantage of multiple cores of machine. For simple task, it
		// is not worth it.
		System.out.println(
				integers.parallelStream()
				.filter(Lambda::isGT3)
				.filter(Lambda::isEven)
				.map(Lambda::doubleIt)
				.findFirst()
				.orElse(0)
		);
		
		int i = 10;
		// You could use object as shared variable, so inside lambda could 
		// modify its state.
		Person person = new Person("John", 44);
		
		// Add i + = 1 to increase the i value inside lambda expression before
		// return i, you will get compilation error: Local variable i defined in
		// an enclosing scope must be final or effectively final.
		// This demonstrates Java closure over values not variables, you could
		// access the state saved at variables, but could not modify it.
		Callable<Integer> callable = () -> {/*i += 1;*/ return i;};
		
		Callable<Person> personCallable = () -> 
			{person.setName("Eric Smith"); return person;};
		
		try {
			System.out.println(callable.call());
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		try {
			System.out.println(personCallable.call().getName());
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		List<Person> people = new ArrayList<>(Arrays.asList(
			new Person("Sara", 12),
			new Person("Mark", 43),
			new Person("Bob", 12),
			new Person("Jill", 64)));
		
		printSorted(people, 
			Comparator.comparing(Person::getAge).thenComparing(Person::getName));
		
		people.removeIf(p -> p.getAge() < 18);
		people.forEach(System.out::println);
	}
=======
    private static final Logger logger = Logger.getLogger(Lambda.class.getName());

    // Use the strategy pattern with selector.
    private static int total(List<Integer> integers,
                             Predicate<Integer> selector) {
        return integers.stream()
                .filter(selector)
                .mapToInt(element -> 2 * element)
                .sum();
    }

    private static boolean isEven(int integer) {
        logger.log(Level.INFO, "isEven for integer: {0}", integer);
        return integer % 2 == 0;
    }

    private static boolean isGT3(int integer) {
        logger.log(Level.INFO, "isGT3 for integer: {0}", integer);
        return integer > 3;
    }

    private static int doubleIt(int integer) {
        logger.log(Level.INFO, "doubleIt for integer: {0}", integer);
        return integer * 2;
    }

    public static boolean isPrime(int number) {
        return number > 1 &&
                IntStream.range(2, number).noneMatch(i -> number % i == 0);
    }

    public static List<Double> sqrtOfFirst100Primes() {
        // collect method use Collectors to accumulating elements into
        // collections, summarizing elements.

        // All the methods except the last one is intermediate methods that do
        // accumulation, the last one is terminal method, until the terminal
        // method is called, all the intermediate methods will be invoked.
        // Otherwise, due to laziness of invocation, they will not be called.
        return Stream.iterate(2, element -> element + 1)
                .filter(Lambda::isPrime)
                .map(Math::sqrt)
                .limit(100)
                .collect(Collectors.toList());
    }

    private static void printSorted(List<Person> people,
                                    Comparator<Person> comparator) {
        // Print the sorted list without change the original list
        people.stream()
                .sorted(comparator)
                .forEach(person -> logger.log(Level.INFO, "{0}", person));
    }

    public static void main(String[] args) {
        logger.info("The first 100 square root of prime numbers are:");
        for (Double sqrtOfPrime : sqrtOfFirst100Primes()) {
            logger.log(Level.INFO, "{0}", sqrtOfPrime);
        }

        List<Integer> integers = Arrays.asList(1, 2, 3, 4, 5, 6, 7, 8, 9, 10);

        integers.forEach(integer -> logger.log(Level.INFO, "{0}", integer));

        // Stream is a sequential used to perform aggregate actions on it.
        logger.info("The summary of square for all numbers:");
        logger.log(Level.INFO, "{0}", integers.stream().map(e -> e * e).reduce(Integer::sum).orElse(0));

        logger.log(Level.INFO, "The total of numbers are: {0}", total(integers, e -> true));
        // Predicate for all even integer
        logger.log(Level.INFO, "The total of even numbers: {0}", total(integers, e -> e % 2 == 0));
        // Predicate for all odd integer
        logger.log(Level.INFO, "The total of odd numbers: {0}", total(integers, e -> e % 2 != 0));

        // Stream is lazy (For all the actions)
        // All the intermediate actions will only be performed if necessary.
        // Or could call it efficient.
        // See the print out for the following statement.
        // Fundamental shift: from imperative to functional style.
        // Stream removes the mutability of existing objects, just construct
        // the new objects based on needs.
        logger.log(Level.INFO, "The first integer after the calculation: {0} ",
                integers.stream()
                        .filter(Lambda::isGT3)
                        .filter(Lambda::isEven)
                        .map(Lambda::doubleIt)
                        .findFirst()
                        .orElse(0)
        );

        // For time consuming processing, just switch stream to parallelStream
        // to take advantage of multiple cores of machine. For simple task, it
        // is not worth it.
        logger.log(Level.INFO, "The first integer after the parallel calculation: {0}",
                integers.parallelStream()
                        .filter(Lambda::isGT3)
                        .filter(Lambda::isEven)
                        .map(Lambda::doubleIt)
                        .findFirst()
                        .orElse(0)
        );

        var i = 10;
        // You could use object as shared variable, so inside lambda could
        // modify its state.
        var person = new Person("John", 44);

        // Add i + = 1 to increase the i value inside lambda expression before
        // return i, you will get compilation error: Local variable i defined in
        // an enclosing scope must be final or effectively final.
        // This demonstrates Java closure over values not variables, you could
        // access the state saved at variables, but could not modify it.
        Callable<Integer> callable = () -> i + 1;

        Callable<Person> personCallable = () ->
        {
            person.setName("Eric Smith");
            return person;
        };

        try {
            logger.log(Level.INFO, "The final result is: {0}", callable.call());
        } catch (Exception e) {
            e.printStackTrace();
        }

        try {
            logger.log(Level.INFO, personCallable.call().getName());
        } catch (Exception e) {
            e.printStackTrace();
        }

        // Arrays.asList returns java.utils.Arrays.ArrayList which is immutable list, you
        // need to warp it with java.utils.ArrayList to generate mutable list.
        List<Person> people = new ArrayList<>(Arrays.asList(
                new Person("Sara", 12),
                new Person("Mark", 43),
                new Person("Bob", 12),
                new Person("Jill", 64)
        ));

        printSorted(people,
                Comparator.comparing(Person::getAge).thenComparing(Person::getName));

        people.removeIf(p -> p.getAge() < 18);

        printSorted(people,
                Comparator.comparing(Person::getAge).thenComparing(Person::getName));
    }
>>>>>>> 6be4e3049d0fa6b6a55515a142a2cc90f94c3049
}
