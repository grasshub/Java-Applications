package org.hong.javafundamental.designpattern.behavioral;

import javax.swing.DefaultListModel;
import javax.swing.JList;
import javax.swing.ListSelectionModel;

public class PickedNameList extends JList<Object> {
	
	private static final long serialVersionUID = -8869831391494097898L;
	@SuppressWarnings("unused")
	private MediatorGUI mediator;
	private DefaultListModel<Object> listModel = new DefaultListModel<Object>();
	
	public PickedNameList(MediatorGUI mediator) {
		super();
		setModel(listModel);
		setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		this.mediator = mediator;
		mediator.register(this);
	}

}
