package org.hong.javafundamental.designpattern.behavioral;

public interface MediatorGUI {
	
	public void copy();
	public void clear();
	public void selectName();
	public void initialize();
	public void register(ClearButton clearButton);
	public void register(CopyButton copyButton);
	public void register(NameList nameList);
	public void register(PickedNameList pickedNameList);
	public void register(PickedName pickedName);

}
