package org.hong.javafundamental.designpattern.behavioral;

//interface for door's behaviors
public interface State {
	
	public void closeDoor(DoorContext doorContext);
	public void openDoor(DoorContext doorContext);
}
