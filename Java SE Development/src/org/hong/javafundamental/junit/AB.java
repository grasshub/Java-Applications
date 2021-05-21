package org.hong.javafundamental.junit;

import java.util.logging.Logger;

public class AB implements B {
	Logger logger = Logger.getLogger(AB.class.getName());
	
	public void a() {
		logger.info("Method a() is invoked!");
	}
	
	public void b() {
		logger.info("Method b() is invoked!");
	}

}
