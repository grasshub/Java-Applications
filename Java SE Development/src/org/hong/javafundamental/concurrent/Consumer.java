package org.hong.javafundamental.concurrent;

import java.util.Random;

public class Consumer implements Runnable {

	private MessageBox messageBox;
	private final String DONE = "Done";
	private final int FIVE_SECONDS = 5 * 1000;
	
	public Consumer(MessageBox messageBox) {
		this.messageBox = messageBox;
	}
	
	public void run() {
		// Using random number to pause the message consuming 
		Random random = new Random(); 
		String message;

		while (!(message = messageBox.take()).equalsIgnoreCase(DONE)) {
			System.out.println("Message received: " + message);
			// Pause for maximum 5 seconds
			try {
				Thread.sleep(random.nextInt(FIVE_SECONDS));
			} catch (InterruptedException e) {
				//Ignore
			}
		}		
	}
}
