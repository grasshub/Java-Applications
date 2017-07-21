package org.hong.javafundamental.designpattern.behavioral;

import javax.swing.JTextField;

public class PickedName extends JTextField {
	
	private static final long serialVersionUID = 8513052904464741137L;
	private MediatorGUI mediator;
	
	public PickedName(MediatorGUI mediator) {
		super(20);
		this.mediator = mediator;
		this.mediator.register(this);
	}

}
