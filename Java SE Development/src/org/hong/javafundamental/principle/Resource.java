package org.hong.javafundamental.principle;

import java.util.function.Consumer;
import java.util.logging.Logger;

public class Resource {
	Logger logger = Logger.getLogger(Resource.class.getName());
	
	// Execute around method for resource clean up
	private Resource() {
		logger.info("External resource created");
	}
	
	public void firstOperation() {
		logger.info("First operation executed");
	}
	
	public void secondOperation() {
		logger.info("Second operation executed");
	}

	private void close() {
		logger.info("External resource cleaned up");
	}
	
	public static void use(Consumer<Resource> consumer) {
		Resource resource = new Resource();
		
		try {
			consumer.accept(resource);
		} finally {
			resource.close();
		}
	}
 	
	public static void main(String[] args) {
		Resource.use(resource -> {
			resource.firstOperation();
			resource.secondOperation();
		});
	}

}
