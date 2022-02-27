package org.hong.javafundamental.junit;

import org.junit.jupiter.api.Test;

import java.util.logging.Logger;

public abstract class BTest extends ATest {
	Logger logger = Logger.getLogger(BTest.class.getName());
	
	protected abstract B getInstance();
	
	@Test
	public void testB() {
		getInstance().b();
		logger.info("In Test B class!");
	}

}
