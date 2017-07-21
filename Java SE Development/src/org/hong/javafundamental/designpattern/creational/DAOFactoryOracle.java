package org.hong.javafundamental.designpattern.creational;

public class DAOFactoryOracle implements DAOFactory {
	
	public DeviceDAO getDeviceDAO() {
		return new DeviceDAOOracle();
	}
	
	public UserDAO getUserDAO() {
		return new UserDAOOracle();
	}

}
