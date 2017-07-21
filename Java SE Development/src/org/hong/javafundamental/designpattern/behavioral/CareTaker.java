package org.hong.javafundamental.designpattern.behavioral;

import java.util.ArrayList;
import java.util.List;

public class CareTaker {

	public static void main(String[] args) {
		
		List<Originator.Memento> stateList = new ArrayList<Originator.Memento>();
		
		Originator originator = new Originator();
		originator.setState("State 1");
		stateList.add(originator.saveToMemento());
		originator.setState("State 2");
		stateList.add(originator.saveToMemento());
		originator.setState("State 3");
		stateList.add(originator.saveToMemento());
		originator.setState("State 4");
		stateList.add(originator.saveToMemento());
		
		for (int index = stateList.size() - 1; index >= 0; index--) 
			originator.restoreFromMemento(stateList.get(index));
		
	}
	
	
}
