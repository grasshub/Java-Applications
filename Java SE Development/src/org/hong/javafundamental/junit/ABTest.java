package org.hong.javafundamental.junit;

import org.junit.jupiter.api.BeforeEach;

public class ABTest extends BTest {
	
	private AB ab;
	
	@BeforeEach
	public void setUp() {
		this.ab = new AB();
	}
	
	protected B getInstance() {
		return ab;
	}

}
