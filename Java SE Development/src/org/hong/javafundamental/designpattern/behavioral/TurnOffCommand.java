package org.hong.javafundamental.designpattern.behavioral;

public class TurnOffCommand implements UndoableCommand {
	
	private Receiver target;
	
	public TurnOffCommand(Receiver receiver) {
		target = receiver;
	}

	public void execute() {
		target.turnOff();
	}
	
	public void undo() {
		target.undo();
	}
	
}