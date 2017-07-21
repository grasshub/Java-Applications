package org.hong.javafundamental.designpattern.behavioral;

public class Wheel implements CarElement {
	
	private String name;
	
	public Wheel(String name) {
		this.name = name;
	}

	public String getName() {
		return name;
	}
	
	public void accept(CarElementVisitor visitor) {
		visitor.visit(this);
	}
	
}
