package org.hong.javafundamental.designpattern.behavioral;

import java.util.Map;

public interface Expression {
	
	public int interpret(Map<String, Expression> context);
}
