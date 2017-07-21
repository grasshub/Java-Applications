package org.hong.javafundamental.designpattern.architectural;

public class ServiceImpl implements Service{

	public String getName() {
		return "ServiceImpl";
	}
	
	public void execute() {
		System.out.println("Executing ServiceImpl");
	}
	
}
