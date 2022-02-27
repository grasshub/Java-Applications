package org.hong.javafundamental.designpattern.behavioral;

import java.awt.event.ActionListener;

import javax.swing.JButton;

public class ClearButton extends JButton implements ClientComponent {

	private static final long serialVersionUID = 8370541891235390109L;
	private final transient MediatorGUI mediator;
	
	public ClearButton(ActionListener listener, MediatorGUI mediator) {
		super("Clear");
		addActionListener(listener);
		this.mediator = mediator;
		mediator.register(this);
	}
	
	public void handleEvent() {
		mediator.clear();
	}
}