package org.hong.javafundamental.designpattern.behavioral;

public class CommandRunner {
	
	public static void main(String[] args) {
		
		Light lamp = new Light();
		UndoableCommand turnOn = new TurnOnCommand(lamp);
		UndoableCommand turnOff = new TurnOffCommand(lamp);
		
		Switch switchBoard = new Switch();
		
		switchBoard.executeCommand(turnOn);
		switchBoard.executeCommand(turnOff);
		switchBoard.undoCommand();
		switchBoard.undoCommand();
		
	}

}
