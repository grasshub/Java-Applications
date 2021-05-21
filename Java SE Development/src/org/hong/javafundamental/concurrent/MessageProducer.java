package org.hong.javafundamental.concurrent;

import java.io.BufferedReader;
import java.io.IOException;
import java.nio.charset.Charset;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.concurrent.ThreadLocalRandom;

public class MessageProducer implements Runnable {
	
	private final MessageBuffer messageBuffer;
	private final Path filePath = Paths.get("Java SE Development/Data File/Songs.txt");
	
	public MessageProducer(MessageBuffer messageBuffer) {
		this.messageBuffer = messageBuffer;
	}
	
	public void run() {

		Charset cs = StandardCharsets.UTF_8;
		String message;
		
		try (BufferedReader bufferedReader = Files.newBufferedReader(filePath, cs)) {
		
			while ((message = bufferedReader.readLine()) != null) {
				
				messageBuffer.put(message);
				sleepOneSecond();
			}

			final String DONE = "Done";
			messageBuffer.put(DONE);
		} catch (IOException|InterruptedException ex) {
			ex.printStackTrace();
			Thread.currentThread().interrupt();
		} 
	}

	private void sleepOneSecond() {
		try {
			// Pause for maximum one second
			// Using random number to pause the message producing
			final int ONE_SECOND = 1000;
			Thread.sleep(ThreadLocalRandom.current().nextInt(ONE_SECOND));
		} catch (InterruptedException e) {
			//Ignore
			Thread.currentThread().interrupt();
		}
	}

}
