package org.hong.javafundamental.designpattern.structural;

public class BridgeRunner {
	
	public static void main(String[] args) {
		
		Shape[] shapes = new Shape[] { new Circle(100, 100, 50, new ConcreateShapeImplA()),
									   new Circle(200, 200, 50, new ConcreteShapeImplB()),
									   new Square(200, 200, 100, 100, new ConcreateShapeImplA()),
									   new Square(100, 100, 100, 100, new ConcreteShapeImplB())
		};
		
		for (Shape shape : shapes) {
			shape.increaseEachSide(10);
			shape.draw();
		}
	}

}
