package org.hong.javafundamental.generics;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Generics {
	
	// PECS Producer extends, Consumer super for pass in arguments to generic API methods.
	/* If pass in argument produces the element in API method, you could pass in ? extends E
	as wildcard type argument to method, if pass in argument consumes the element from API method,
	you could pass in ? super E to method. If argument is both producer and consumer, then
	you could only pass in same element type E. If argument is neither producer nor consumer,
	you could only pass in element type as ? meaning any type.
	The return type could not contain wildcard type since otherwise user needs to deal with it.
	For example, there is Stack<E> with void pushAll(Collection<E> src);
										void popAll(Collection<E> dst);
	those two methods should change to: void pushAll(Collection<? extends E> src);
										void popAll(Collection<? super E> dst);
	to make them more flexible.
	For instance, Caller can now pushAll from a collection<Long> or Collection<Number> onto
	a Stack<Number>.
	Call can now popAll into a Collection<Object> or Collection<Number> from a Stack<Number>.
	Since List<Long> is not subtype of List<Number>.
	*/

	List<? extends Number> nuList;

	public static <T extends Comparable<T>> int countGreaterThan(T[] anArray, T elem) {
		int count = 0;
		for (T e : anArray)
			if (e.compareTo(elem) > 0)
				++count;
		return count;
	}

	private class Person {}

	public static void addNumbers(List<? super Integer> list) {
		for (int i = 1; i <= 10; i++) {
			list.add(i);
		}
	}

	public static double sumOfList(List<? extends Number> list) {
		double s = 0.0;
		for (Number n : list)
			s += n.doubleValue();
		return s;
	}

	public static void printList(List<Object> list) {
		for (Object elem : list)
			System.out.println(elem + " ");
		System.out.println();
	}

	public static void printList1(List<?> list) {
		for (Object elem : list)
			System.out.print(elem + " ");
		System.out.println();
	}
	
	// Can not create instances of type parameters
	/*
	public static <E> void append(List<E> list) {
	    E elem = new E();  // compile-time error
	    list.add(elem);
	}
	*/
	
	public static <E> void append(List<E> list, Class<E> cls) throws Exception {
	    E elem = cls.newInstance();
	    list.add(elem);
	}

	public static void main(String[] args) throws CloneNotSupportedException {

		/*
		 * private class Person {
		 * 
		 * }
		 */
		// restriction on generics
		/*
		Node<int> intNode = new Node<int>(1);
		*/
		
		B b = new B(2);
		B b1 = (B)b.clone();
		b.setC(3);
		System.out.println(b.getC());
		System.out.println(b1.getC());
		
		String[] stringArr = {"first", "second"};
		for (String string: stringArr)
			System.out.println(string);
		
		A.assertionTest();
		
		List<String> ls = new ArrayList<>();
		
		try {
			append(ls, String.class);
			System.out.println("The size of list after append method: " + ls.size());
		} catch (Exception e1) {
			e1.printStackTrace();
		}
		
		Number[] numArray = new Number[2];
		numArray[0] = 1;
		numArray[1] = 1.1;
		
		for (Number n: numArray)
			System.out.println("The list of number: " + n);
		
		
		List<String> list = new ArrayList<>();
		//List<String>[] listArr = new List<String>[2];
		if(list instanceof ArrayList<?>)
			System.out.println("Good");
		
		// Array must contain single type of object
		/*
		Object[] strings = new String[2];
		strings[0] = "hi";   // OK
		strings[1] = 100;    // An ArrayStoreException is thrown.
		*/
				
		MyNode mn = new MyNode(5);
		Node<Integer> n = mn;
		Integer x = n.data;
		System.out.println(x);

		List<Integer> li = new ArrayList<>();
		List<Number> ln = new ArrayList<>();
		addNumbers(li);
		addNumbers(ln);

		Integer[] intArray = new Integer[20];
		intArray[0] = 0;
		Number[] numArr = intArray;
		System.out.println("Number: " + numArr[1]);

		// Person person = new Person();
		Person person = new Generics().new Person();

		System.out.println("The name of Integer class: "
				+ person.getClass().getName());

		List<? super B> aSub = new ArrayList<>();
		aSub.add(new B(2));
		Object aO = aSub.get(0);
		System.out.println(aO);

		try {
			Class<?> pers = Class.forName("org.hong.javafundamental.generics.Generics$Person");
			System.out.println(pers.toString());
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}

		/*
		 * Person[] intArr = new Person[2]; intArr[0] = new Person(); intArr[1]
		 * = new Person(); Person elem = new Person(); int count =
		 * countGreaterThan(intArr, elem); System.out.println("Count is: " +
		 * count);
		 */

		List<B> bList = new ArrayList<>();
		bList.add(new B(2));
		List<? extends A> aList = bList;
		A aNum = aList.get(0);
		System.out.println(aNum);

		List<Integer> ints = new ArrayList<>();
		ints.add(4);
		ints.add(2);
		double sum = sumOfList(ints);
		System.out.println("The sum of list: " + sum);

		List<Number> nums = new ArrayList<>();
		List<? super Integer> baseInt = nums;
		baseInt.add(1);
		nums.add(1);
		nums.add(1.1);

		List<Double> ld = Arrays.asList(1.2, 2.3, 3.5);
		System.out.println("sum = " + sumOfList(ld));

		System.out.println("The numbers: " + baseInt.get(2));

		List<? super Integer> iList = new ArrayList<>();
		iList.add(1);
		System.out.println("Number List: " + iList.get(0));
		ints.add(2);
		System.out.println("Number List: " + nums.get(1));

		NaturalNumber<? extends Number> numberA = new NaturalNumber<>(1);
		System.out.println("Even number: " + numberA.isEven());

		numberA = new NaturalNumber<>(2.0);
		System.out.println("Even number: " + numberA.isEven());
			
	}

}
