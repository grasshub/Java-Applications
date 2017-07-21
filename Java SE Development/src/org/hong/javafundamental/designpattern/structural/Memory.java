package org.hong.javafundamental.designpattern.structural;

public class Memory {

	public void load(long bootAddress, byte[] data) {
		System.out.println("Memory loads the boot driver from hard disk to address: " + bootAddress);
	}
}
