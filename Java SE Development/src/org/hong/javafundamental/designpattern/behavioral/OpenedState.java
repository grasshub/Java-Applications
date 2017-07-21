package org.hong.javafundamental.designpattern.behavioral;

// Door in opened state
public class OpenedState implements State {
	
	public void openDoor(DoorContext doorContext) {
		System.out.println("The door is already opened");
	}
	
	public void closeDoor(DoorContext doorContext) {
		System.out.println("The door is closed");
		doorContext.setState(doorContext.getClosedState());
	}
}
    