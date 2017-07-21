package org.hong.javafundamental.designpattern.behavioral;

public class Car {
	
	//Based on strategy pattern, behaviors should not be inherited, they should
	//be defined inside interfaces. Using interface inheritance with object composition,
	//you can achieve the great flexibility to plug in new behaviors to you class
	
	private IBrakeBehavior brakeBehavior = new Brake(); //default brake behavior 
	private IAccelerateBehavior accelerateBehavior = new Accelerate(); //default accelerate behavior

	// switch to specific strategy for braking
	public void setBreakBehavior(IBrakeBehavior brakeBehavior) {
		this.brakeBehavior = brakeBehavior;
	}
	
	public void setAccelerateBehavior(IAccelerateBehavior accelerateBehavior) {
		this.accelerateBehavior = accelerateBehavior;
	}
	
	public void brake() {
		brakeBehavior.brake();
	}
	
	public void accelerate() {
		accelerateBehavior.accelerate();
	}
	
}
