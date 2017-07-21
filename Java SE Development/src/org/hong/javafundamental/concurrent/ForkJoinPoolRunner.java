package org.hong.javafundamental.concurrent;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ForkJoinPool;
import java.util.concurrent.ThreadLocalRandom;

public class ForkJoinPoolRunner {
	
	private static final int SIZE = 10000;
	
	public static void main(String[] args) {
		
		List<Integer> sortList = new ArrayList<Integer>(SIZE);
		
		// Adding 10000 random integer to sortList
		for (int i = 0; i < SIZE; i++) {
			int value = ThreadLocalRandom.current().nextInt();
			sortList.add(value);
		}
		
		QuickSort<Integer> quickSort = new QuickSort<Integer>(sortList);
		
		ForkJoinPool pool = new ForkJoinPool();
		pool.invoke(quickSort);
		
		for (int i = 0; i < SIZE; i++) {
			System.out.println(sortList.get(i));
		}
	}

}
