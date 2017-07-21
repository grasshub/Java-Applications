package org.hong.javafundamental.designpattern.behavioral;

public class CarWhole implements CarElement {
	
	private CarElement[] carElements;
	
	public CarWhole() {
		carElements = new CarElement[] {new Wheel("Front left"), new Wheel("Front right"), new Wheel("Back left"), new Wheel("Back right"), new Engine(), new Body()};
	}
	
	public void accept(CarElementVisitor visitor) {
		for (CarElement carElement : carElements) {
			carElement.accept(visitor);
		}
		visitor.visit(this);
	}

}
