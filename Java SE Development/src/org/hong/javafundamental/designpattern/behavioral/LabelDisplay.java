package org.hong.javafundamental.designpattern.behavioral;

import java.awt.Font;

import javax.swing.JLabel;

public class LabelDisplay extends JLabel {

	private static final long serialVersionUID = -4282985532832899771L;

	public LabelDisplay(Mediator mediator) {
		mediator.registerDisplay(this);
		setFont(new Font("Arial", Font.BOLD, 24));
	}

}
