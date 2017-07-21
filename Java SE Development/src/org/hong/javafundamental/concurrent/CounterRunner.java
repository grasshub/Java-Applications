package org.hong.javafundamental.concurrent;

import java.util.Random;

public class CounterRunner {
	
	private static final int MAXIMUM = 20;
	private final static int THREE_SECONDS = 3 * 1000;
	private final static Random random = new Random();
	
	public static void main(String[] args) {
		
		final Counter count = new Counter();
		
		new Thread(new Runnable() {
			public void run() {
				for (int i = 0; i <= MAXIMUM; i++) {
					count.increment();
					try {
						Thread.sleep(random.nextInt(THREE_SECONDS));
					} catch (InterruptedException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}					
				}
			}
		}).start();

		new Thread(new Runnable() {
			public void run() {
				for (int i = 0; i <= MAXIMUM; i++) {
					count.decrement();
					try {
						Thread.sleep(random.nextInt(THREE_SECONDS));
					} catch (InterruptedException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}					
				}
			}
		}).start();
		
		new Thread(new Runnable() {
			public void run() {
				for (int i = 0; i <= MAXIMUM; i++) {
					count.get();
					try {
						Thread.sleep(random.nextInt(THREE_SECONDS));
					} catch (InterruptedException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}					
				}
				System.out.println("The final count value is: " + count.get());
			}
		}).start();	
	}

}
