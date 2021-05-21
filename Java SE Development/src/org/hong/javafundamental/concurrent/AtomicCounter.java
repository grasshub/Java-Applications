package org.hong.javafundamental.concurrent;

import java.util.concurrent.atomic.AtomicInteger;

public class AtomicCounter {
	
	private final AtomicInteger count = new AtomicInteger(0);
	
	public void increment() {
		int oldValue = count.getAndIncrement();
		System.out.printf("The count value changes from %d -> %d%n", oldValue, count.get());
	}
	
	public void decrement() {
		int oldValue = count.getAndDecrement();
		System.out.printf("The count value changes from %d -> %d%n", oldValue, count.get());
	}
	
	public int get() {
		return count.get();
	}

}
