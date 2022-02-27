package org.hong.javafundamental.principle;

import java.util.logging.Logger;

public class PassByReference {

	static Logger logger = Logger.getLogger(PassByReference.class.getName());
	
	public static void main(String[] arg) {
		
		Person person = new Person("Mark", 22);
		// try pass by reference here
		Person anotherPerson = person.changePerson(person);
		
		/* Passing object as argument to method should not called as pass by 
		 * reference in Java, call by sharing or call by object sharing is the
		 * better name. Inside method you could modify the mutable object passed
		 * as argument, however, you don't have the direct access to original 
		 * object to assign new object to it. Doing so inside method will 
		 * create a local argument not sharing with the original object. Outside
		 * object passed into the method is shared, but once the method decides
		 * to overwrite it, the sharing is off and the method only plays with 
		 * its own version. However, if method returns the local version of argument
		 * and assign it to original object, it could change original object.
		 */
		logger.info(anotherPerson.getName());
		logger.info(person.getName());
	}
}