package org.hong.javafundamental.designpattern.behavioral;

public class ClosedState implements State {
	
	public void openDoor(DoorContext doorContext) {
		System.out.println("The door is opened");
		doorContext.setState(doorContext.getOpenedState());
	}
	
	public void closeDoor(DoorContext doorContext) {
		System.out.println("The door is already closed");
	}

}
