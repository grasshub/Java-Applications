package org.hong.javafundamental.junit;

import org.junit.*;

public class ABTest extends BTest {
	
	private AB ab;
	
	@Before
	public void setUp() {
		this.ab = new AB();
	}
	
	protected B getInstance() {
		return ab;
	}

}
