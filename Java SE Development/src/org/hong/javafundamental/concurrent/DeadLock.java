package org.hong.javafundamental.concurrent;

public class DeadLock {
	
	private static class Friend {
		
		private final String name;
		
		public Friend(String name) {
			this.name = name;
		}
		
		public String getName() {
			return name;
		}
		
		public synchronized void bowBack(Friend bower) {
			
			System.out.printf("%s: bow back to %s%n", this.name, bower.getName());
		}
		
		public synchronized void bow(Friend bower) {
			
			System.out.printf("%s: waiting for %s to bow back to me%n", this.name, bower.getName());
			bower.bowBack(this);			
		}
	}
	
	public static void main(String[] args) {
		
		final Friend john = new Friend("John");
		final Friend dave = new Friend("Dave");
		
		new Thread(new Runnable() {
			public void run() {
				john.bow(dave);
			}
		}).start();
		
		new Thread(new Runnable() {
			public void run() {
				dave.bow(john);
			}
		}).start();			
	}

}
