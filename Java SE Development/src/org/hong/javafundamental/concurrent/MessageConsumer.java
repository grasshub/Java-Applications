package org.hong.javafundamental.concurrent;

import java.util.concurrent.ThreadLocalRandom;

public class MessageConsumer implements Runnable {
	
	private final MessageBuffer messageBuffer;

	public MessageConsumer(MessageBuffer messageBuffer) {
		this.messageBuffer = messageBuffer;
	}
	
	public void run() {
		
		String message;
			
		try {
			final String DONE = "Done";
			while (!((message = messageBuffer.take()).equalsIgnoreCase(DONE))) {
				System.out.println("Message received: " + message);
				// Pause for maximum one second
				// Using random number to pause the message consuming 
				final int ONE_SECOND = 1000;
				Thread.sleep(ThreadLocalRandom.current().nextInt(ONE_SECOND));
			} 
		} catch (InterruptedException e) {
			//Ignore
			e.printStackTrace();
			Thread.currentThread().interrupt();
		}
	}

}
