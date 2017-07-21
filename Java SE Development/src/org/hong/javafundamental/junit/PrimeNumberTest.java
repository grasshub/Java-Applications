package org.hong.javafundamental.junit;

import static org.junit.Assert.assertEquals;

import java.util.Arrays;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import org.junit.runners.Parameterized.Parameters;


@RunWith(Parameterized.class)
public class PrimeNumberTest {
	
	private int number;
	private boolean isPrime;
	
	public PrimeNumberTest(int number, boolean isPrime) {
		this.number = number;
		this.isPrime = isPrime;
	}
	
	@Parameters
	public static Iterable<Object[]> primeNumbers() {
		
		return Arrays.asList(new Object[][] {
			{2, true},
			{4, false},
			{5, true},
			{6, false},
			{8, false},
			{9, false}
		});	
	}
	
	@Test
	public void validatePrimeNumbers() {
		System.out.println("Parameterized test with parameters: " + number + " " + isPrime);
		assertEquals(isPrime, PrimeNumber.isPrime(number));	
	}

}
