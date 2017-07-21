package org.hong.javafundamental.junit;

import org.junit.Test;

public abstract class ATest {
	
	protected abstract A getInstance();
	
	@Test
	public void testA() {
		A a = getInstance();
		System.out.println("In Test A class!");
		a.a();
	}
	

}
