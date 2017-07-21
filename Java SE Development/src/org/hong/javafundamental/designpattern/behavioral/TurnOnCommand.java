package org.hong.javafundamental.designpattern.behavioral;

public class TurnOnCommand implements UndoableCommand {
	
	private Receiver target;
	
	public TurnOnCommand(Receiver receiver) {
		target = receiver;
	}

	public void execute() {
		target.turnOn();
	}
	
	public void undo() {
		target.undo();
	}
	
}
