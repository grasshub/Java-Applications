package org.hong.javafundamental.designpattern.structural;

public abstract class Shape {
	
	protected ShapeImplementation shapeImpl;

	public abstract void draw();
	public abstract void increaseEachSide(double percentage);
}
