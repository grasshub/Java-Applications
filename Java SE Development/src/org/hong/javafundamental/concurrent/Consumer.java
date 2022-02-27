package org.hong.javafundamental.concurrent;

import lombok.RequiredArgsConstructor;

import java.security.SecureRandom;

@RequiredArgsConstructor
public class Consumer implements Runnable {

	private final MessageBox messageBox;
	static final String DONE = "Done";
	static final int FIVE_SECONDS = 5 * 1000;
	// Using secure random number to pause the message consuming
	private final SecureRandom secureRandom = new SecureRandom();

	public void run() {
		String message;

		while (!(message = messageBox.take()).equalsIgnoreCase(DONE)) {
			System.out.println("Message received: " + message);
			// Pause for maximum 5 seconds
			try {
				Thread.sleep(secureRandom.nextInt(FIVE_SECONDS));
			} catch (InterruptedException e) {
				//Ignore
				Thread.currentThread().interrupt();
			}
		}		
	}
}
