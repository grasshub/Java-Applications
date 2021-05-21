package org.hong.javafundamental.junit;

import org.junit.jupiter.api.Test;

import java.util.logging.Logger;

public abstract class ATest {
	Logger logger = Logger.getLogger(ATest.class.getName());
	
	protected abstract A getInstance();
	
	@Test
	public void testA() {
		A a = getInstance();
		logger.info("In Test A class!");
		a.a();
	}
	

}
