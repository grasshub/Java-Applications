package org.hong.javafundamental.designpattern.behavioral;

import java.util.Observable;
import java.util.Observer;

public class ReadLineObserver implements Observer {
	
	private String response;
	
	public void update(Observable observable, Object arg) {
		
		if (arg instanceof String)
			response = (String) arg;
		
		System.out.println("Received input string from ReadLineObservable as: " + response);
		
	}

}
