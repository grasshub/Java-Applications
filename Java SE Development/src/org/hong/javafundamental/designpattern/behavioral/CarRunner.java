package org.hong.javafundamental.designpattern.behavioral;

public class CarRunner {
	
	public static void main(String[] args) {
		
		Car car;
		
		//Two cars using different strategies
		car = new Car();
		
		car.setBreakBehavior(new BrakeWithABS());
		car.brake();
		car.setAccelerateBehavior(new AccelerateWithTurbo());
		car.accelerate();
		
		car.setBreakBehavior(new Brake());
		car.brake();
		car.setAccelerateBehavior(new Accelerate());
		car.accelerate();
		
	}

}
