package org.hong.javafundamental.concurrent;

import java.util.concurrent.ThreadLocalRandom;

public class MessageConsumer implements Runnable {
	
	private MessageBuffer messageBuffer;
	private final String DONE = "Done";
	private final int ONE_SECOND = 1000;
	
	public MessageConsumer(MessageBuffer messageBuffer) {
		this.messageBuffer = messageBuffer;
	}
	
	public void run() {
		
		String message;
			
		try {
			while (!((message = messageBuffer.take()).equalsIgnoreCase(DONE))) {
				System.out.println("Message received: " + message);
				// Pause for maximum one second
				// Using random number to pause the message consuming 
				Thread.sleep(ThreadLocalRandom.current().nextInt(ONE_SECOND));
			} 
		} catch (InterruptedException e) {
			//Ignore
			e.printStackTrace();
		}
	}

}
