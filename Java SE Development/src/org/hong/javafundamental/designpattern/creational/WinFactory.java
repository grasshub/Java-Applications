package org.hong.javafundamental.designpattern.creational;

public class WinFactory implements GUIFactory {
	public Button createButton() {
		return new WinButton();
	}
}
