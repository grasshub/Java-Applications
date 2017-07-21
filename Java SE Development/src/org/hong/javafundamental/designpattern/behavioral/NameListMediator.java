package org.hong.javafundamental.designpattern.behavioral;

import javax.swing.DefaultListModel;
import javax.swing.JOptionPane;

public class NameListMediator implements MediatorGUI {
	
	private ClearButton clearButton;
	private CopyButton copyButton;
	private NameList nameList;
	private PickedNameList pickedNameList;
	private PickedName pickedName;
	
	public void register(ClearButton clearButton) {
		this.clearButton = clearButton;
	}
	
	public void register(CopyButton copyButton) {
		this.copyButton = copyButton;
	}
	
	public void register(NameList nameList) {
		this.nameList = nameList;
	}
	
	public void register(PickedNameList pickedNameList) {
		this.pickedNameList = pickedNameList;
	}
	
	public void register(PickedName pickedName) {
		this.pickedName = pickedName;
	}
	
	public void selectName() {
		String name = (String)nameList.getSelectedValue();
		pickedName.setText(name);
		copyButton.setEnabled(true);
	}
	
	public void copy() {
		DefaultListModel<Object> pickedNameModel = (DefaultListModel<Object>)pickedNameList.getModel();
		//prevent duplicated name
		if (!pickedNameModel.contains(pickedName.getText())) {
			pickedNameModel.addElement(pickedName.getText());
			clearButton.setEnabled(true);
		}
	}
	
	public void clear() {
		DefaultListModel<Object> pickedNameModel = (DefaultListModel<Object>)pickedNameList.getModel();
		if (pickedNameModel.size() != 0) {
			if (pickedNameList.isSelectionEmpty())
				JOptionPane.showMessageDialog(null, "Please select a name to clear.", "Error", JOptionPane.ERROR_MESSAGE);
			else
				pickedNameModel.remove(pickedNameList.getSelectedIndex());			
		}

		pickedName.setText("");
		nameList.clearSelection();
		
		copyButton.setEnabled(false);
		if (pickedNameModel.size() == 0)
			clearButton.setEnabled(false);
	}
	
	public void initialize() {
		clear();
	}

}
