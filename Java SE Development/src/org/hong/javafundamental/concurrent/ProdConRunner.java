package org.hong.javafundamental.concurrent;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class ProdConRunner {
	
	public static void main(String[] args) {
		
		MessageBuffer messageBuffer = new MessageBuffer();
		
		ExecutorService executorService = Executors.newCachedThreadPool();
		executorService.submit(new MessageProducer(messageBuffer));
		
		executorService.submit(new MessageConsumer(messageBuffer));	

		// Terminates the related thread pool after all tasks are completed
		executorService.shutdown();
	}
	
}
