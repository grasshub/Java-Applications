package org.hong.javafundamental.designpattern.creational;

public interface DAOFactory {
	
	//return an implementation of DeviceDAO, specific to a particular database
	DeviceDAO getDeviceDAO();
	
	UserDAO getUserDAO();
}
