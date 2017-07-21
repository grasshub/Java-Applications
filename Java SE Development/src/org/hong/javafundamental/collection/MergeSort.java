package org.hong.javafundamental.collection;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class MergeSort {
	
	private static final int ZERO = 0;
	private static final int ONE = 1;
	private static final int TWO = 2;
	private static final Integer[] INT_ARRAY = {
		38, 27, 43, 3, 9, 82, 10, 99, 4, 3, 88, 4
	};
	
	@SuppressWarnings("unchecked")
	private static <E> List<Comparable<E>> merge(List<? extends Comparable<E>> left, List<? extends Comparable<E>> right) {
		
		List<Comparable<E>> result = new ArrayList<Comparable<E>>();
		
		while (left.size() > ZERO || right.size() > ZERO) 
			if (left.size() > ZERO && right.size() > ZERO)
				if (left.get(ZERO).compareTo((E) right.get(ZERO)) <= ZERO)
					result.add(left.remove(ZERO));
				else
					result.add(right.remove(ZERO));
			else if (left.size() > ZERO) {
				result.addAll(left);
				left.clear();
			}
			else if (right.size() > ZERO) {
				result.addAll(right);
				right.clear();
			}
		
		return result;
	}
	
	@SuppressWarnings("unchecked")
	private static <E> List<? extends Comparable<E>> merge_sort(List<? extends Comparable<E>> list) {
		
		// if list size is 0 (empty) or 1, consider it sorted and return it
		// (using less than or equal prevents infinite recursion for a zero length list
		if (list.size() <= ONE) 
			return list;
		
		// else list size is greater than 1, so split the list into two sublists
		List<Comparable<E>> left = new ArrayList<Comparable<E>>();
		List<Comparable<E>> right = new ArrayList<Comparable<E>>();
		int middle = list.size() / TWO;
		
		left.addAll(list.subList(ZERO, middle));
		right.addAll(list.subList(middle, list.size()));
		
		// recursively call merge_sort() to further split each sublist 
		// until sublist size is 1
		left = (List<Comparable<E>>) merge_sort(left);
		right = (List<Comparable<E>>) merge_sort(right);
		
		// merge the sublists returned from prior calls to merge_sort()
		// and return the resulting merged sublist
		return merge(left, right);		
	}
	
	@SuppressWarnings("unchecked")
	public static void main(String[] args) {
		
		List<Integer> list = Arrays.asList(INT_ARRAY);
		
		list = (List<Integer>) merge_sort(list);
		System.out.println(list);
	}

}
