package org.hong.javafundamental.designpattern.creational;

public class PrototypeImpl implements Prototype, Cloneable {
	
	private int intValue;
	
	public PrototypeImpl(int intValue) {
		this.intValue = intValue;
	}
	
	@Override
	public int getIntValue() {
		return intValue;
	}
	
	@Override
	public void setIntValue(int intValue) {
		this.intValue = intValue;
	}
	
	@Override
	public Prototype clone() throws CloneNotSupportedException {
		return (Prototype)super.clone();
	}

}
