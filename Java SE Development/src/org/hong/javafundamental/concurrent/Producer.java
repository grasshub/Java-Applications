package org.hong.javafundamental.concurrent;

import java.util.Random;

public class Producer implements Runnable {
	
	private MessageBox messageBox;
	private final int FIVE_SECONDS = 5 * 1000;
	private final String DONE = "Done";
	
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
		
		// Using random number to pause the message producing 
		Random random = new Random(); 
				
		for (int i = 0; i < messageList.length; i++) {
			messageBox.put(messageList[i]);
			// Pause for maximum 5 seconds
			try {
				Thread.sleep(random.nextInt(FIVE_SECONDS));
			} catch (InterruptedException e) {
				//Ignore
			}
		}
		
		// Signals the end of message
		messageBox.put(DONE);
	}

}
