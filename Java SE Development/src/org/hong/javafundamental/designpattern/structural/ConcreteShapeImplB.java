package org.hong.javafundamental.designpattern.structural;

public class ConcreteShapeImplB implements ShapeImplementation {
	
	public void draw(double x, double y, double radius) {
		System.out.printf("ConcreateShapeImplB draw circle at %f %f with radius %f%n", x, y, radius);
	}
	
	public void draw(double x, double y, double width, double height) {
		System.out.printf("ConcreateShapeImplB draw square at %f %f with width %f and height %f%n", x, y, width, height);
	}
}
