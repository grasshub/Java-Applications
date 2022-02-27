package org.hong.javafundamental.principle;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.logging.Logger;

public class LazyInitialization {
	static Logger logger = Logger.getLogger(LazyInitialization.class.getName());

	// Lazy initialization holder class idiom for static fields
	// Nested class is not loaded until it is referenced.
	// This idiom almost magical. There's synchronization going on, but it's
	// invisible. The Java Runtime does it for you, behind the scenes. And many
	// VMs actually patch the code to eliminate the sync once it's no longer 
	// necessary, so this idiom is extremely fast.
	private static class FieldHolder {
		static final String FIELD = "static variable";
	}
	
	public static String getStaticField() {return FieldHolder.FIELD;}
	
	// Use the double-check idiom with a volatile field for high performance lazy
	// initialization for instance field. This idiom wasn't guaranteed to work
	// until release 5.0, when the platform got a new memory model. The idiom is 
	// very fast but also complicated and delicate, so don't be tempted to modify 
	// it in any way. Just copy and paste.
	private volatile String field;
	
	public String getInstanceField() { 
		String result = field;
		
		// First check (no locking)
		if (result == null) {
			synchronized(this) { 
				result = field;
				// Second check (with locking)
				if (result == null) {
					field = result = "instance variable";
				}
			}
		}
		return result;	
	}

	public static void main(String[] args) {
		
		ExecutorService executorService = Executors.newFixedThreadPool(6);
		
		Runnable staticFieldRunnable = () -> {
			logger.info("Asynchronous task for static variable");
			for (int i = 0; i < 6; i++) {
				logger.info(LazyInitialization.getStaticField());
			}
		};
		
		Runnable instanceFieldRunnable = () -> {
			logger.info("Asynchronous task for instance variable");
			LazyInitialization lazyInitialization = new LazyInitialization();
			for (int i = 0; i < 6; i++) {
				logger.info(lazyInitialization.getInstanceField());
			}
		};

		// Execute getStaticField and getInstanceField method in six threads
		executorService.execute(staticFieldRunnable);
		
		executorService.execute(instanceFieldRunnable);
		executorService.execute(instanceFieldRunnable);
		
		executorService.execute(staticFieldRunnable);
		executorService.execute(staticFieldRunnable);
		
		executorService.execute(instanceFieldRunnable);

		executorService.shutdown();
		
	}

}
