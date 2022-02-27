package org.hong.javafundamental.designpattern.behavioral;

import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;

public class MediatorGUIRunner extends JFrame implements ActionListener {
	
	private static final long serialVersionUID = -6900504903443577953L;

	public MediatorGUIRunner() {
		
		JPanel panel = new JPanel();
		MediatorGUI mediator = new NameListMediator();
		panel.add(new PickedName(mediator));
		panel.add(new CopyButton(this, mediator));
		panel.add(new ClearButton(this, mediator));
		
		JPanel panelCenter = new JPanel();
		panelCenter.setLayout(new GridLayout(1,2));
		JScrollPane listScroller = new JScrollPane(new NameList(mediator));
		panelCenter.add(listScroller);
		panelCenter.add(new PickedNameList(mediator));	
		
		getContentPane().add(panel, "North");
		getContentPane().add(panelCenter, "Center");
		
		this.setTitle("Mediator Demo");
		setSize(800, 600);
		setVisible(true);
		mediator.initialize();
	}
	
	public void actionPerformed(ActionEvent e) {
		ClientComponent client = (ClientComponent)e.getSource();
		client.handleEvent();
	}
	
	public static void main(String[] args) {
		new MediatorGUIRunner();
	}
}
