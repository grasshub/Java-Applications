package org.hong.javafundamental.designpattern.behavioral;

public class StateRunner {
	
	public static void main(String[] args) {
		
		DoorContext context;
		
		context = new DoorContext();
		
		context.closeDoor();
		context.openDoor();
		
		context.openDoor();
		context.closeDoor();
		
		context.closeDoor();
		
	}

}
