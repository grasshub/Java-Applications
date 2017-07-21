package org.hong.javafundamental.generics;

public class B extends A implements Cloneable {

	private int c;
		
	public B(int c) {
		this.c = c;
		// TODO Auto-generated constructor stub
	}
	
	public int getC() {
		return c;
	}
	
	public void setC(int c) {
		this.c = c;
	}
	
	public Object clone() throws CloneNotSupportedException {
		
		return (B)super.clone();
	}

}
