package org.hong.javafundamental.designpattern.behavioral;

import java.util.ArrayList;
import java.util.List;

public class Switch {
	
	private List<UndoableCommand> commandHistory = new ArrayList<UndoableCommand>();
	
	public Switch() {
		
	}
	
	public void executeCommand(UndoableCommand command) {
		commandHistory.add(command);
		command.execute();
	}
	
	public void undoCommand() {
		// undo the last command 
		UndoableCommand command = commandHistory.get(commandHistory.size() - 1);
		commandHistory.remove(commandHistory.size() -1);
		command.undo();
	}
	
}
