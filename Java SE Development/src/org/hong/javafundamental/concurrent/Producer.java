package org.hong.javafundamental.concurrent;

import java.util.Random;

public class Producer implements Runnable {
	
	private final MessageBox messageBox;

	// Using random number to pause the message producing
	private final Random random = new Random();

	public Producer(MessageBox messageBox) {
		this.messageBox = messageBox;
	}
	
	public void run() {
		
		String[] messageList = {
				"Mares eat oats",
				"Donkeys eat oats",
				"Little lambs eat ivy",
				"A kid will eat ivy too"
		};

		for (String s : messageList) {
			messageBox.put(s);
			// Pause for maximum 5 seconds
			try {
				final int FIVE_SECONDS = 5 * 1000;
				Thread.sleep(random.nextInt(FIVE_SECONDS));
			} catch (InterruptedException e) {
				//Ignore
				Thread.currentThread().interrupt();
			}
		}
		
		// Signals the end of message
		final String DONE = "Done";
		messageBox.put(DONE);
	}

}
