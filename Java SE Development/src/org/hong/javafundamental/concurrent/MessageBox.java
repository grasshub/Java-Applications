package org.hong.javafundamental.concurrent;

public class MessageBox {
	
	// Message sent from producer to consumer
	private String message;
	private boolean empty = true;
	
	public synchronized String take() {
		
		// Wait until message is available
		while(empty)
			try {
				wait();
			} catch (InterruptedException e) {
				// Ignore
				Thread.currentThread().interrupt();
			}
		
		// Toggle the flag
		empty = true;
		// Notify producer the status 
		notifyAll();
		return message;	
	}
	
	public synchronized void put(String message) {
		
		// Wait until message has retrieved
		while(!empty)
			try {
				wait();
			} catch (InterruptedException e) {
				// Ignore
				Thread.currentThread().interrupt();
			}
		
		// Toggle the flag
		empty = false;
		this.message = message;
		// Notify consumer the status 
		notifyAll();	
	}

}
