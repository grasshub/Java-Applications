package org.hong.javafundamental.designpattern.behavioral;

public class Engine implements CarElement {
	
	public void accept(CarElementVisitor visitor) {
		visitor.visit(this);
	}

}
