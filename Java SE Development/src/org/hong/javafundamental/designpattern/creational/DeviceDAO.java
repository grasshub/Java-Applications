package org.hong.javafundamental.designpattern.creational;

public interface DeviceDAO {
	
	public Device fetch(String name);
	public void add(Device device);
	public void delete(Device device);

}
