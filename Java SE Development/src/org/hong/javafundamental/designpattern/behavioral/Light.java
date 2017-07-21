package org.hong.javafundamental.designpattern.behavioral;

public class Light implements Receiver {
	
	private String state = "turn off";
	
	public void turnOn() {
		System.out.println("Turn on the light");
		state = "turn on";
	}
	
	public void turnOff() {
		System.out.println("Turn off the light");
		state = "turn off";
	}
	
	public void undo() {
		
		if (state.equalsIgnoreCase("turn off")) {
			state = "turn on";
			System.out.println("Turn on the light");
		}
		else {
			state = "turn off";
			System.out.println("Turn off the light");
		}
	}

}
