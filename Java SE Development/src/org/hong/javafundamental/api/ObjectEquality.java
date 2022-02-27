package org.hong.javafundamental.api;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class ObjectEquality {

	public static void main(String[] args) {
		String[] strings = {"0", "1", "2", "3", "4", "5"};
		
		// Translate string array into List of Integer
		List<Integer> integers = new ArrayList<>();
		for (String string: strings) {
			integers.add(Integer.valueOf(string));
		}

		// Integer operator <, >, <= and >= works with auto unboxing
// == and != do not work, need same object
		integers.sort(Integer::compareTo);
		
		// return 1
		System.out.println(Collections.binarySearch(integers, 1));

		// Integer operator <, >, <= and >= works with auto unboxing
// == and != do not work, need same object
		integers.sort((i1, i2) -> {
			// Unbox arguments to force value comparison
			int i1Unbox = i1;
			int i2Unbox = i2;
			return Integer.compare(i1Unbox, i2Unbox);
		});
		
		System.out.println(Collections.binarySearch(integers, 1));
	}

}

