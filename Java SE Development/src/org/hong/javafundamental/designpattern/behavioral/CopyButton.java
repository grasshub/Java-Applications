package org.hong.javafundamental.designpattern.behavioral;

import java.awt.event.ActionListener;

import javax.swing.JButton;

public class CopyButton extends JButton implements ClientComponent {
	
	private static final long serialVersionUID = 7411271046592905970L;
	private MediatorGUI mediator;
	
	public CopyButton(ActionListener listener, MediatorGUI mediator) {
		super("Copy");
		addActionListener(listener);
		this.mediator = mediator;
		mediator.register(this);
	}
	
	public void handleEvent() {
		mediator.copy();
	}
}
