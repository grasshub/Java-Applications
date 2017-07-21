package org.hong.javafundamental.generics;

import java.util.*;

public class ArrayBuilder {

	@SuppressWarnings("unchecked")
	public static <T> void addToList (List<T> listArg, T... elements)
	{
		for (T x : elements) {
			listArg.add(x);
		}
	}

	@SuppressWarnings("unchecked")
	public static void faultyMethod(List<String>... l) {
		Object[] objectArray = l;     // Valid
		objectArray[0] = Arrays.asList(42);
	//	String s = l[0].get(0);       // ClassCastException thrown here
	}

}
