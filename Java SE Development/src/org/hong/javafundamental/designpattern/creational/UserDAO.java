package org.hong.javafundamental.designpattern.creational;

public interface UserDAO {
	
	User fetch(String name);
	void add(User user);
	void delete(User user);
}
