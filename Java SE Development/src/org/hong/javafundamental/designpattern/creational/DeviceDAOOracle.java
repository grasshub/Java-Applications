package org.hong.javafundamental.designpattern.creational;

public class DeviceDAOOracle implements DeviceDAO {
	
	public Device fetch(String name) {
		//select it from Oracle database table and parse it to a Device
		System.out.println("Retrieve the device from oracle database with name: " +name);
		return new Device("Device");
	}
	
	public void add(Device device) {
		//insert this device to database table
		System.out.println("Insert the device to oracle database with name: " + device.getName());
	}
	
	public void delete(Device device) {
		//delete this device from database table
		System.out.println("Delete the device from oracle database with name: " + device.getName());
	}

}
