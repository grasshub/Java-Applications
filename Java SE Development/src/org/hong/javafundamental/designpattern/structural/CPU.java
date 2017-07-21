package org.hong.javafundamental.designpattern.structural;

public class CPU {

	public void freeze() {
		System.out.println("CPU freezes");
	}
	
	public void jump(long bootAddress) {
		System.out.printf("CPU jumps to boot address: %d%n", bootAddress);
	}
	
	public void execute() {
		System.out.println("CPU executes to start computer");
	}
}
