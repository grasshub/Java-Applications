package org.hong.javafundamental.designpattern.behavioral;

import javax.swing.JButton;

public class ViewButton extends JButton implements Client {
	
	private static final long serialVersionUID = 3347483324025046723L;
	private final Mediator mediator;
	
	public ViewButton(Mediator mediator) {
		super("View");
		this.mediator = mediator;
		mediator.registerView(this);		
	}
	
	public void handleEvent() {
		mediator.view();
	}

}