package org.hong.javafundamental.designpattern.architectural;

public class InitialContext {
	
	public Object lookup(String jndiName) {
		
		if (jndiName.equals("ServiceImpl")) {
			System.out.println("Looking up and creating a new ServiceImpl object");
			return new ServiceImpl();
		}
		else if (jndiName.equals("ServiceImplA")) {
			System.out.println("Looking up and creating a new ServiceImplA object");
			return new ServiceImplA();
		}
		
		return null;
	}

}
