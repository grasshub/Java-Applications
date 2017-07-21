package org.hong.javafundamental.designpattern.structural;

public class Circle extends Shape {
	
	private double x;
	private double y;
	private double radius;
	
	public Circle(double x, double y, double radius, ShapeImplementation shapeImpl) {
		this.x = x;
		this.y = y;
		this.radius = radius;
		this.shapeImpl = shapeImpl;
	}
	
	// low level method (Implementation specific)
	public void draw() {
		shapeImpl.draw(x, y, radius);
	}
	
	// high level method (Abstraction specific)
	public void increaseEachSide(double percentage) {
		radius = radius * (1 + percentage/100);
	}

}
