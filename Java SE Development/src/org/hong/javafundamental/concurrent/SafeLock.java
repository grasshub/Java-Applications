package org.hong.javafundamental.concurrent;

import java.security.SecureRandom;
import java.util.Random;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class SafeLock {
	
	private static final int ONE_SECOND = 1000;
	
	private static class Friend {
		
		private final String name;
		private final Lock lock = new ReentrantLock();
	
		public Friend(String name) {
			this.name = name;
		}
		
		public String getName() {
			return name;
		}
		
		// Try to acquire both locks for self and friend in order to complete bow action 
		// and receive bowBack from friend. If could not get both locks, release the holding 
		// lock to allow friend to perform the same action. (Deadlock is prevented.)
		public boolean impendingBow(Friend bower) {
			
			boolean ownLock = false;
			boolean friendLock = false;
			
			try {
				ownLock = lock.tryLock();
				friendLock = bower.lock.tryLock();
			} finally {		
				if (!(ownLock && friendLock)) {
					if (ownLock)
						lock.unlock();
					if (friendLock)
						bower.lock.unlock();				
				}
			}
			
			return ownLock && friendLock;
		
		}
		
		public void bowBack(Friend bower) {			
			System.out.printf("%s: bow back to %s%n", this.name, bower.getName());
		}
		
		public void bow(Friend bower) {
			if (impendingBow(bower)) {
				try {
					System.out.printf("%s: waiting for %s to bow back to me%n", this.name, bower.getName());
					bower.bowBack(this);	
				} finally {
					lock.unlock();
					bower.lock.unlock();
				}
			} else {
				System.out.printf("%s: %s started to bow to me, so I will wait for my turn%n", this.name, bower.getName());
			}
					
		}
	}
	
	private static class BowLoop implements Runnable {
		
		private final Friend bowee;
		private final Friend bower;
		private final Random random = new Random(); // SecureRandom is preferred to Random
		
		public BowLoop(Friend bowee, Friend bower) {
			this.bowee = bowee;
			this.bower = bower;
		}
		
		public void run() {
			
			for (;;) {
				try {
					Thread.sleep(random.nextInt(ONE_SECOND));
				} catch (InterruptedException ex) {
					// Ignore
					Thread.currentThread().interrupt();
				}
				
				bowee.bow(bower);
			}
		}
	}
	
	public static void main(String[] args) {
		
		final Friend john = new Friend("John");
		final Friend dave = new Friend("Dave");
		
		new Thread(new BowLoop(john, dave)).start();	
		new Thread(new BowLoop(dave, john)).start();			
	}
	
}
