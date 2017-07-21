package org.hong.javafundamental.designpattern.structural;

public class Square extends Shape {
	
	private double x;
	private double y;
	private double width;
	private double height;
	
	public Square(double x, double y, double width, double height, ShapeImplementation shapeImpl) {
		this.x = x;
		this.y = y;
		this.width = width;
		this.height = height;
		this.shapeImpl = shapeImpl;
	}
	
	// low level method (Implementation specific)
	public void draw() {
		shapeImpl.draw(x, y, width, height);
	}
	
	// high level method (Abstraction specific)
	public void increaseEachSide(double percentage) {
		x = x - (width * percentage/100)/2;
		y = y - (height * percentage/100)/2;
		width = width * (1 + percentage/100);
		height = height * (1 + percentage/100);
	}

}
