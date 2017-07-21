package org.hong.javafundamental.designpattern.behavioral;

public class Originator {
	
	private String state;
	
	public void setState(String state) {
		System.out.println("Originator sets the state to: " + state);
		this.state = state;
	}
	
	public Memento saveToMemento() {
		System.out.printf("Originator saves the state: %s to memento%n", state);
		return new Memento(state);
	}
	
	public void restoreFromMemento(Memento memento) {
		System.out.printf("Originator restores the state to: %s retrieving from memento%n", memento.getState());
		state = memento.getState();
	}
	
	public static class Memento {
		
		private String state;
		
		// make sure only Originator could create Memento
		private Memento(String state) {
			this.state = state;
		}
		
		// make sure only Originator could retrieve state from Memento
		private String getState() {
			return state;
		}
		
	}

	
}
