package org.hong.javafundamental.designpattern.architectural;

public class ServiceImplA implements Service{

	public String getName() {
		return "ServiceImplA";
	}
	
	public void execute() {
		System.out.println("Executing ServiceImplA");
	}
	
}
