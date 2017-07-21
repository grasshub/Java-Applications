package org.hong.javafundamental.designpattern.creational;

public interface UserDAO {
	
	public User fetch(String name);
	public void add(User user);
	public void delete(User user);

}
