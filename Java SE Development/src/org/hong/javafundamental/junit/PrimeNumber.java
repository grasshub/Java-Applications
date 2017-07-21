package org.hong.javafundamental.junit;

public class PrimeNumber {
	
	public static boolean isPrime(int number) {
		
		boolean primeNumber = true;
		int limit = (int) Math.sqrt(number);
		
		for (int i = 2; i <= limit; i++) {
			if (number % i == 0) {
				primeNumber = false;
				break;
			}
		}
		
		return primeNumber;
	}

}
