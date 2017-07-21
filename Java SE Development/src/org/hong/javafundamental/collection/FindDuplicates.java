package org.hong.javafundamental.collection;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;
import java.util.List;
import java.util.Random;
import java.util.Set;
import java.util.TreeSet;

public class FindDuplicates {
	
	private static void findDuplicates(String[] args) {
		Set<String> set = new TreeSet<String>(); //new HashSet<String>();
		
		for (String string: args) 
			if (!set.add(string)) 
				System.out.println("Duplicate detected: " + string);
		
		System.out.println(set.size() + " distinct words: " + set);
	}
	
	private static void findDupsAndUniques(String[] args) {
		Set<String> uniqueSet = new HashSet<String>();
		Set<String> dupSet = new HashSet<String>();
		
		for (String string: args) 
			if (!uniqueSet.add(string)) 
				dupSet.add(string);
		
		uniqueSet.removeAll(dupSet);
		
		System.out.println("Unique words: " + uniqueSet);
		System.out.println("Duplicate words: " + dupSet);
	}
	
	private static void shuffle(String[] args) {
		List<String> list = new ArrayList<String>();
		
		for (String string: args) 
			list.add(string);
		
		Collections.shuffle(list, new Random());
		
		System.out.println(list);
	}
	
	public static void main(String[] args) {
		
		findDuplicates(args);
		findDupsAndUniques(args);
		shuffle(args);
	}

}
