package org.hong.javafundamental.designpattern.behavioral;

import java.util.Observable;
import java.util.Observer;

public class ReadStringObserver implements Observer{
	
	public void update(Observable observable, Object arg) {

		System.out.println("Received string from ReadLineObservable as: " + arg);
		
	}

}
