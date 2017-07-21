package org.hong.javafundamental.designpattern.behavioral;

import javax.swing.JButton;

public class SearchButton extends JButton implements Client {

	private static final long serialVersionUID = 5494735170747528063L;
	private Mediator mediator;
	
	public SearchButton(Mediator mediator) {
		super("Search");
		this.mediator = mediator;
		mediator.registerSearch(this);		
	}
	
	public void handleEvent() {
		mediator.search();
	}

}