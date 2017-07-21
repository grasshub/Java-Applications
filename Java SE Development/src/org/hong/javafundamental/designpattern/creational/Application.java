package org.hong.javafundamental.designpattern.creational;

public class Application {
	
	public Application(GUIFactory factory) {
		Button button = factory.createButton();
		button.paint();
	}
	
	public Application(DAOFactory factory) {
		DeviceDAO deviceDao = factory.getDeviceDAO();
		UserDAO userDao = factory.getUserDAO();
		
		Device device = deviceDao.fetch("my device");
		deviceDao.add(device);
		
		User user = userDao.fetch("my user");
		userDao.add(user);
	}
}
