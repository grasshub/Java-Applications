package org.hong.javafundamental.designpattern.behavioral;

import javax.swing.JButton;

public class BookButton extends JButton implements Client {
	
	private static final long serialVersionUID = -2353863975368607049L;
	transient Mediator mediator;
	
	public BookButton(Mediator mediator) {
		super("Book");
		this.mediator = mediator;
		mediator.registerBook(this);		
	}
	
	public void handleEvent() {
		mediator.book();
	}

}
