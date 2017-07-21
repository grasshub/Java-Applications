package org.hong.javafundamental.concurrent;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class SimpleThreads {

	// one minute to milliseconds
	private static final int WAIT_TIME = 12 * 1000;
	private static final int TWO_SECONDS = 2 * 1000;
	private static final int FOUR_SECONDS = 4 * 1000;
	private static final String YES = "yes";
	private static final String Y = "y";
	
	// Display a message, proceeded with name of current thread
	private static void threadMessage(String message) {
		
		String threadName = Thread.currentThread().getName();
		System.out.printf("%s: %s%n", threadName, message);
	}
	
	private static class MessageLoop implements Runnable {
		
		public void run() {
			
			String[] messageList = {
					"Mares eat oats",
					"Donkeys eat oats",
					"Little lambs eat ivy",
					"A kid will eat ivy too"
			};
			
			try {
				for (int i = 0; i < messageList.length; i++) {
					// Pause for 4 seconds
					Thread.sleep(FOUR_SECONDS);
					threadMessage(messageList[i]);
				}
			} catch (InterruptedException ex) {
				threadMessage("MessageLoop didn't finish!");
			}
		}
		
	}
		
	public static void main(String[] args) throws InterruptedException {
		
		threadMessage("Starting MessageLoop thread");
		long startTime = System.currentTimeMillis();
		Thread thread = new Thread(new MessageLoop());
		thread.start();

		threadMessage("Waiting for MessageLoop thread to finish");

		// loop until MessageLoop thread exits
		while (thread.isAlive()) {
			threadMessage("Still waiting...");

			// each time wait for two seconds before checks if maximum waiting time is due
			thread.join(TWO_SECONDS);
			if (((System.currentTimeMillis() - startTime) > WAIT_TIME) && thread.isAlive()) {
				threadMessage("Tired of waiting!");
				thread.interrupt();

				System.out.println("The MessageLoop thread is not completed yet, do you want to wait?");
				try (BufferedReader reader = new BufferedReader(new InputStreamReader(System.in))) {
					String answer = reader.readLine();
					if (answer.equalsIgnoreCase(YES) || answer.equalsIgnoreCase(Y)) 
						thread.join();
				} catch (IOException ex) {
					System.err.println("Could not get user's answer due to the following exception");
					System.err.println(ex.getMessage());
				}
			}
		}

		threadMessage("Finally everything is done!");	
	}

}
