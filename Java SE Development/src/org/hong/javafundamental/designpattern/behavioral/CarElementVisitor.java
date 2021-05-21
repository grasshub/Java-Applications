package org.hong.javafundamental.designpattern.behavioral;

public interface CarElementVisitor {
	
	void visit(Wheel wheel);
	void visit(Engine engine);
	void visit(Body body);
	void visit(CarWhole car);

}
