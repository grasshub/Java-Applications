package org.hong.javafundamental.api;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class ObjectEquality {

	public static void main(String[] args) {
		String[] strings = {"0", "1", "2", "3", "4", "5"};
		
		// Translate string array into List of Integer
		List<Integer> integers = new ArrayList<>();
		for (String string: strings) {
			integers.add(Integer.valueOf(string));
		}
		
		integers.sort(new Comparator<Integer>() {
			@Override
			// Integer operator <, >, <= and >= works with auto unboxing
			// == and != do not work, need same object
			public int compare(Integer i1, Integer i2) {
				return i1 < i2 ? -1 : (i1 == i2 ? 0: 1);
			}
		});
		
		// return 1
		System.out.println(Collections.binarySearch(integers, new Integer(1)));
		
		integers.sort(new Comparator<Integer>() {
			@Override
			// Integer operator <, >, <= and >= works with auto unboxing
			// == and != do not work, need same object
			public int compare(Integer i1, Integer i2) {
				// Unbox arguments to force value comparison
				int i1Unbox = i1;
				int i2Unbox = i2;
				return i1Unbox < i2Unbox ? -1 : (i1Unbox == i2Unbox ? 0: 1);
			}
		});
		
		System.out.println(Collections.binarySearch(integers, new Integer(1)));
	}

}

