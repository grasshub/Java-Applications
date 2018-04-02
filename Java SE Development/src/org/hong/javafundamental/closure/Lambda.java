package org.hong.javafundamental.closure;

import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.concurrent.Callable;
import java.util.function.Predicate;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.stream.Stream;

import org.hong.javafundamental.principle.Person;

public class Lambda {
	
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
		List<Double> sqrtOfFirst100Primes = 
			Stream.iterate(2, e -> e + 1)
				  .filter(Lambda::isPrime)
				  .map(Math::sqrt)
				  .limit(100)
				  .collect(Collectors.toList());
		
		return sqrtOfFirst100Primes;
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
		System.out.println(
			integers.stream()
			.map(e -> e * e)
			.reduce((total, e) -> total + e)
			.get()
		);
		
		System.out.println(total(integers, e -> true));
		// Predicate for all even integer
		System.out.println(total(integers, e -> e % 2 == 0));
		// Predicate for all odd integer
		System.out.println(total(integers, e -> e % 2 != 0));
		
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
		
		List<Person> people = Arrays.asList(
			new Person("Sara", 12),
			new Person("Mark", 43),
			new Person("Bob", 12),
			new Person("Jill", 64));
		
		printSorted(people, 
			Comparator.comparing(Person::getAge).thenComparing(Person::getName));
		
		people.removeIf(p -> p.getAge() < 18);
		
	}
}
