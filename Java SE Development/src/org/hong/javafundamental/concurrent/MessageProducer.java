package org.hong.javafundamental.concurrent;

import java.io.BufferedReader;
import java.io.IOException;
import java.nio.charset.Charset;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.concurrent.ThreadLocalRandom;

public class MessageProducer implements Runnable {
	
	private MessageBuffer messageBuffer;
	private final int ONE_SECOND =  1000;
	private final String DONE = "Done";
	private final Path filePath = Paths.get("Data File/Songs.txt");
	
	public MessageProducer(MessageBuffer messageBuffer) {
		this.messageBuffer = messageBuffer;
	}
	
	public void run() {
		
		Charset cs = Charset.forName("UTF-8");
		String message;
		
		try (BufferedReader bufferedReader = Files.newBufferedReader(filePath, cs)) {
		
			while ((message = bufferedReader.readLine()) != null) {
				
				messageBuffer.put(message);
			
				try {
					// Pause for maximum one second
					// Using random number to pause the message producing
					Thread.sleep(ThreadLocalRandom.current().nextInt(ONE_SECOND));
				} catch (InterruptedException e) {
					//Ignore
				}
			
			}
			
			messageBuffer.put(DONE);
		} catch (IOException|InterruptedException ex) {
			ex.printStackTrace();
		} 
	}
	
}
