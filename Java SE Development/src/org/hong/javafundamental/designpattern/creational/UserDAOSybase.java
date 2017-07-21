package org.hong.javafundamental.designpattern.creational;

public class UserDAOSybase implements UserDAO {
	
	public User fetch(String name) {
		//select it from Oracle database table and parse it to a User
		System.out.println("Retrieve the user from sybase database with name: " + name);
		return new User(name);
	}
	
	public void add(User user) {
		//insert this device to database table
		System.out.println("Insert the user to sybase database with name: " + user.getName());
	}
	
	public void delete(User user) {
		//delete this device from database table
		System.out.println("Delete the user from sybase database with name: " + user.getName());
	}

}
