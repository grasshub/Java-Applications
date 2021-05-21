package org.hong.javafundamental.designpattern.creational;

public interface Prototype {
	Prototype clone() throws CloneNotSupportedException;
	
	int getIntValue();
	void setIntValue(int intValue);
}
