package org.hong.javafundamental.concurrent;

public class Counter {
	
	private int count = 0;
		
	public void increment() {
		count++;
	}

	public void decrement() {
		count--;
	}

	public int get() {
		return count;
	}

}
