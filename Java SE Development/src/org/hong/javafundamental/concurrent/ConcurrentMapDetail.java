package org.hong.javafundamental.concurrent;

import java.util.Arrays;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ConcurrentMap;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class ConcurrentMapDetail {
	
	private static final ConcurrentMap<String, String> map = 
		new ConcurrentHashMap<>();
	
	private static final String[] data = {"hi", "hello", "good", "night", "world"};
	
	// Interning map atop ConcurrentMap -- BROKEN
	public static String intern(String string) {
		synchronized(map) { // Always wrong
			return map.putIfAbsent(string, string);
		}
	}
	
	// Interning map atop ConcurrentMap -- the right way
	public static String internRevised(String string) {
		String result = map.get(string);
		if (result == null) {
			// call putIfAbsent only if map doesn't contain entry 2 times faster,
			// and far less contention.
			// result is null if value put into map, however, if there is race
			// condition, another thread could put in the value first, then return
			// that value. Always verify the result for this method, otherwise, you
			// could return the wrong result.
			result = map.putIfAbsent(string, string);
			if (result == null) {
				result = string;
			}
		}
		return result;
	}

	public static void main(String[] args) {
		
		ExecutorService executorService = Executors.newFixedThreadPool(6);
		
		Runnable internRunnable = () -> {
			System.out.println("Asynchronous task");
			for (String key: data) {
				System.out.println(intern(key));
			}
		};
		
		Runnable internRevisedRunnable = () -> {
			System.out.println("Asynchronous task revised");
			for (String key: data) {
				System.out.println(internRevised(key));
			}
		};

		// Execute intern and internRevised method in six threads
		executorService.execute(internRunnable);
		
		executorService.execute(internRevisedRunnable);
		executorService.execute(internRevisedRunnable);
		
		executorService.execute(internRunnable);
		executorService.execute(internRunnable);
		
		executorService.execute(internRevisedRunnable);

		executorService.shutdown();
		
		System.out.println(Arrays.toString(data));
	}

}
