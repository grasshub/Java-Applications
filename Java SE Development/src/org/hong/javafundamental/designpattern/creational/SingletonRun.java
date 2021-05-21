package org.hong.javafundamental.designpattern.creational;

public class SingletonRun {

	/**
	 *
	 */
	public static void main(String[] args) {
		Singleton singleton = Singleton.INSTANCE;
		//universe = new Universe();
		singleton.setName("Universe");
		System.out.println("The name of universe: " + singleton.getName());
		singleton.execute("go fishing");
	}

}
