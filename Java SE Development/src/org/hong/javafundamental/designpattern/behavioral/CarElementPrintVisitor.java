package org.hong.javafundamental.designpattern.behavioral;

public class CarElementPrintVisitor implements CarElementVisitor {
	
	public void visit(Wheel wheel) {
		System.out.printf("Visit the %s wheel%n", wheel.getName());
	}
	
	public void visit(Engine engine) {
		System.out.println("Visit the enginee");
	}
	
	public void visit(Body body) {
		System.out.println("Visit the body");
	}
	
	public void visit(CarWhole car) {
		System.out.println("Visit the car");
	}

}
