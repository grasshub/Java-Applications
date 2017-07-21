package org.hong.javafundamental.designpattern.creational;

public class Pizza {
	
	private String dough = "";
	private String sauce = "";
	private String topping = "";
	
	public void setDough(String dough) {
		this.dough = dough;
	}
	
	public String getDough() {
		return dough;
	}
	
	public void setSauce(String sauce) {
		this.sauce = sauce;
	}
	
	public String getSauce() {
		return sauce;
	}
	
	public void setTopping(String topping) {
		this.topping = topping;
	}
	
	public String getTopping() {
		return topping;
	}

}
