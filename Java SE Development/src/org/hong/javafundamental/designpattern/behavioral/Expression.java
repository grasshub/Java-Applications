package org.hong.javafundamental.designpattern.behavioral;

import java.util.Map;

public interface Expression {
	
	int interpret(Map<String, Expression> context);
}
