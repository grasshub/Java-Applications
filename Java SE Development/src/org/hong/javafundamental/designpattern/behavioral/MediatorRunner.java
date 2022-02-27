package org.hong.javafundamental.designpattern.behavioral;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;

public class MediatorRunner extends JFrame implements ActionListener {
	
	private static final long serialVersionUID = -3422345241935369779L;

	public MediatorRunner() {
		
		JPanel panel = new JPanel();

		Mediator mediator = new ConcreteMediator();
		JButton button = new BookButton(mediator);
		button.addActionListener(this);
		panel.add(button);
		
		button = new ViewButton(mediator);
		button.addActionListener(this);
		panel.add(button);
		
		button = new SearchButton(mediator);
		button.addActionListener(this);
		panel.add(button);
		
		getContentPane().add(new LabelDisplay(mediator), "North");
		getContentPane().add(panel, "South");
		
		setSize(400, 200);
		setVisible(true);
	}
	
	public void actionPerformed(ActionEvent e) {
		Client client = (Client) e.getSource();
		client.handleEvent();
	}
	
	public static void main(String[] args) {
		new MediatorRunner();
	}
}
