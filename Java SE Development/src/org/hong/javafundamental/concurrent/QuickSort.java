package org.hong.javafundamental.concurrent;

import java.util.List;
import java.util.concurrent.RecursiveAction;

public class QuickSort<T extends Comparable<T>> extends RecursiveAction {
	
	private static final long serialVersionUID = -7067438592049181237L;
	private List<T> data;
	private int left;
	private int right;
	private final int ZERO = 0;
	
	public QuickSort(List<T> data) {
		this.data = data;
		this.left = ZERO;
		this.right = data.size() - 1;
	}
	
	public QuickSort(List<T> data, int left, int right) {
		this.data = data;
		this.left = left;
		this.right= right;
	}
	
	private void swap(int i, int j) {
		
		if (i != j) {
			T temp = data.get(i);
			
			data.set(i, data.get(j));
			data.set(j, temp);
		}
	}
	
	private int partition(int pivot) {
		
		T pivotValue = data.get(pivot);
		// Move the pivot element to the right most position
		swap(pivot, right);
		// New pivot position after move all the items smaller than pivot to the left of pivot item,
		// and all the items bigger than pivot to the right of pivot
		int pivotNew = left;
		for (int i = left; i < right; i++) {
			if (data.get(i).compareTo(pivotValue) < ZERO) {
				swap(i, pivotNew);
				pivotNew++;
			}
		}
		
		// Move pivot to its final position
		swap(pivotNew, right);
		return pivotNew;	
	}
	
	@Override
	protected void compute() {
		
		if (left < right) {
			
			// Selects the pivot
			int pivot = left + (right - left)/2;
			// Get lists of smaller and bigger items and final position of pivot
			pivot = partition(pivot);
			// Recursively sort elements smaller and bigger than the pivot
			invokeAll(new QuickSort<T>(data, left, pivot -1), new QuickSort<T>(data, pivot + 1, right)); 
		}
	}	

}
