package org.hong.javafundamental.concurrent;

import java.util.Random;

public class CounterRunner {
	
	private static final int MAXIMUM = 20;
	private static final int THREE_SECONDS = 3 * 1000;
	private static final Random random = new Random();
	
	public static void main(String[] args) {
		
		final Counter count = new Counter();
		
		new Thread(() -> {
			for (int i = 0; i <= MAXIMUM; i++) {
				count.increment();
				try {
					Thread.sleep(random.nextInt(THREE_SECONDS));
				} catch (InterruptedException e) {
					e.printStackTrace();
					Thread.currentThread().interrupt();
				}
			}
		}).start();

		new Thread(() -> {
			for (int i = 0; i <= MAXIMUM; i++) {
				count.decrement();
				try {
					Thread.sleep(random.nextInt(THREE_SECONDS));
				} catch (InterruptedException e) {
					e.printStackTrace();
					Thread.currentThread().interrupt();
				}
			}
		}).start();
		
		new Thread(() -> {
			for (int i = 0; i <= MAXIMUM; i++) {
				count.get();
				try {
					Thread.sleep(random.nextInt(THREE_SECONDS));
				} catch (InterruptedException e) {
					e.printStackTrace();
					// Restore interrupted state...
					Thread.currentThread().interrupt();
				}
			}
			System.out.println("The final count value is: " + count.get());
		}).start();
	}

}
