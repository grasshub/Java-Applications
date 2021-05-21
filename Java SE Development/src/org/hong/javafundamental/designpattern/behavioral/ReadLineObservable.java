package org.hong.javafundamental.designpattern.behavioral;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Observable;

public class ReadLineObservable extends Observable implements Runnable {
	
	public void run() {
		final BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
		String inputString = "";
		
		while(true) {
			System.out.println("Enter a string > ");
			try {
				inputString = bufferedReader.readLine();
			} catch (IOException e) {
				e.printStackTrace();
			}
			setChanged();
			notifyObservers(inputString);
		}
	}

}
