package org.hong.javafundamental.api;

public class Varargs {
	
	// If invoked with no argument, it will throw runtime exception
	private static int min(int ... args) {
		if (args.length == 0) {
			throw new IllegalArgumentException("Too few arguments");
		}
		
		int min = args[0];
		for (int i = 1; i < args.length; i++) {
			if (args[i] < min) {
				min = args[i];
			}
		}
		return min;
	}
	
	// This one will get compile time error
	private static int minimal(int firstArg, int ... remainingArgs) {
		int minimal = firstArg;
		for (int arg: remainingArgs) {
			if (arg < minimal) {
				minimal = arg;
			}
		}
		return minimal;
	}

	public static void main(String[] args) {
		int min = min();
		//int minimal = minimal();
	}

}
