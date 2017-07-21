package org.hong.javafundamental.junit;

import org.junit.*;

public class TestClass2 {
	
	@Test(expected=ArithmeticException.class)
	public void dividedByZero() {	
		@SuppressWarnings("unused")
		int i = 1 / 0;
	}
	
	@Ignore("Not ready to run")
	@Test
	public void addNumber() {
		System.out.println("Method is not ready to run!");
	}
	
	@Test(timeout=1000)
	public void infinity() {
		while (true);
	}

}
