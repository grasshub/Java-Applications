package org.hong.javafundamental.junit;

import org.junit.Test;

public abstract class BTest extends ATest {
	
	protected abstract B getInstance();
	
	@Test
	public void testB() {
		getInstance().b();
		System.out.println("In Test B class!");
	}

}
