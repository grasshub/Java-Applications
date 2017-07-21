package org.hong.javafundamental.jaxb;

import java.io.File;
import java.util.Arrays;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Marshaller;
import javax.xml.bind.Unmarshaller;

public class ObjectToXML {
	
	private static final int ID = 100;
	private static final String NAME = "John Doe";
	private static final int AGE = 44;
	private static final Phone[] PHONE_NUMBERS = {new Phone("home", "302-777-1111"), new Phone("business", "302-111-7777")};
	private static final String FILE_PATH = "C:/mytemp/xmlFile.xml";
	private static final boolean TRUE = true;
	
	public static void main(String[] args) {
		Customer customer = new Customer();
		
		customer.setId(ID);
		customer.setName(NAME);
		customer.setAge(AGE);
		customer.setPhones(Arrays.asList(PHONE_NUMBERS));
		
		try {
			File xmlFile = new File(FILE_PATH);
			
			// Phone class is referenced from Customer class, so there is no needs to specify here
			JAXBContext context = JAXBContext.newInstance(Customer.class);
			Marshaller jaxbMarshaller = context.createMarshaller();
			
			// Output formatted
			jaxbMarshaller.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, TRUE);
			
			// Convert object to xml file and print to Console
			jaxbMarshaller.marshal(customer, xmlFile);
			jaxbMarshaller.marshal(customer, System.out);
			
			// The next part will convert xml file to java object
			Unmarshaller jaxbUnmarshaller = context.createUnmarshaller();
			Customer customerObject = (Customer) jaxbUnmarshaller.unmarshal(xmlFile);
			
			System.out.println(customerObject.toString());
		}
		catch (JAXBException e) {
			e.printStackTrace();
		}
	}

}
