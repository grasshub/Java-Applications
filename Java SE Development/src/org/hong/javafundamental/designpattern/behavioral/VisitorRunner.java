package org.hong.javafundamental.designpattern.behavioral;

public class VisitorRunner {
	
	public static void main(String[] args) {
		CarWhole car = new CarWhole();
		
		car.accept(new CarElementPrintVisitor());
		car.accept(new CarElementPrintMoreVisitor());
	}

}
