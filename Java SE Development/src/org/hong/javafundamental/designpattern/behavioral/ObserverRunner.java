package org.hong.javafundamental.designpattern.behavioral;

public class ObserverRunner {
	
	public static void main(String[] args) {
		
		ReadLineObservable readLineObservable = new ReadLineObservable();
		readLineObservable.addObserver(new ReadLineObserver());
		readLineObservable.addObserver(new ReadStringObserver());
		
		Thread thread = new Thread(readLineObservable);
		thread.start();
	
	}

}
