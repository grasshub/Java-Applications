package org.hong.javafundamental.designpattern.creational;

public class DAOFactorySybase implements DAOFactory {
	
	public DeviceDAO getDeviceDAO() {
		return new DeviceDAOSybase();
	}
	
	public UserDAO getUserDAO() {
		return new UserDAOSybase();
	}

}
