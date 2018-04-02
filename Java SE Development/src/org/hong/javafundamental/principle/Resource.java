package org.hong.javafundamental.principle;

import java.util.function.Consumer;

public class Resource {
	
	// Execute around method for resource clean up
	private Resource() {
		System.out.println("External resource created");
	}
	
	public void firstOperation() {
		System.out.println("First operation executed");
	}
	
	public void secondOperation() {
		System.out.println("Second operation executed");
	}

	private void close() {
		System.out.println("External resource cleaned up");
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
