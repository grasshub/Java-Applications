package org.hong.javafundamental.designpattern.structural;

public class HardDriver {
	
	public byte[] read(long bootSection, int size) {
		System.out.println("The hard driver reads boot driver from boot section with address: " + bootSection);
		return new byte[size];
	}

}
