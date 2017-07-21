package org.hong.javafundamental.designpattern.behavioral;

public class Body implements CarElement {
	
	public void accept(CarElementVisitor visitor) {
		visitor.visit(this);
	}

}
