package org.hong.javafundamental.designpattern.structural;

public class CoffeeOrderContext {
	
	private int tableNumber;
	
	public CoffeeOrderContext(int tableNumber) {
		this.tableNumber = tableNumber;
	}
	
	public int getTable() {
		return tableNumber;
	}
}
