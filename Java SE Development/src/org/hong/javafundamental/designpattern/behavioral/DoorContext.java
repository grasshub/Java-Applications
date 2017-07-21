package org.hong.javafundamental.designpattern.behavioral;

public class DoorContext {
	
	private State state;
	private State closedState = new ClosedState();
	private State openedState = new OpenedState();
	
	public DoorContext() {
		state = closedState;
	}
	
	public void setState(State state) {
		this.state = state;
	}
	
	public State getClosedState() {
		return closedState;
	}
	
	public State getOpenedState() {
		return openedState;
	}

	public void openDoor() {
		state.openDoor(this);
	}
	
	public void closeDoor() {
		state.closeDoor(this);
	}
}
