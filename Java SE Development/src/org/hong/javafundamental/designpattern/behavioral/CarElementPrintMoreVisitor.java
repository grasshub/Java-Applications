package org.hong.javafundamental.designpattern.behavioral;

public class CarElementPrintMoreVisitor implements CarElementVisitor {
	
	public void visit(Wheel wheel) {
		System.out.printf("Kick the %s wheel%n", wheel.getName());
	}
	
	public void visit(Engine engine) {
		System.out.println("Start the engine");
	}
	
	public void visit(Body body) {
		System.out.println("Start the body");
	}
	
	public void visit(CarWhole car) {
		System.out.println("Start the car");
	}

}
