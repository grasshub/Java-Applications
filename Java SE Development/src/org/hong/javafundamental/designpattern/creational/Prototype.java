package org.hong.javafundamental.designpattern.creational;

public interface Prototype {
	public Prototype clone() throws CloneNotSupportedException;
	
	public int getIntValue();
	public void setIntValue(int intValue);
}
