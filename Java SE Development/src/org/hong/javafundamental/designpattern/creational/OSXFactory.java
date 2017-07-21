package org.hong.javafundamental.designpattern.creational;

public class OSXFactory implements GUIFactory {
	public Button createButton() {
		return new OSXButton();
	}
}
