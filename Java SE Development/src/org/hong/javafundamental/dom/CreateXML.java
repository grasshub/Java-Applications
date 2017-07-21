package org.hong.javafundamental.dom;

import java.io.File;

import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.transform.OutputKeys;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerException;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;

import org.w3c.dom.Document;
import org.w3c.dom.Element;

public class CreateXML {
	
	private static final String COMPANY = "company";
	private static final String STAFF = "staff";
	private static final String ID = "id";
	private static final String FIRST_NAME = "firstname";
	private static final String LAST_NAME = "lastname";
	private static final String NICK_NAME = "nickname";
	private static final String SALARY = "salary";
	private static final String ONE = "1";
	private static final String JOHN = "John";
	private static final String DOE = "Doe";
	private static final String JDOE = "JDoe";
	private static final String EIGHTY_THOUSAND = "800000";
	private static final String FILE_PATH = "C:/mytemp/xmlOutput.xml";
	private static final String YES = "yes";
	private static final String INDENT_URL = "{http://xml.apache.org/xslt}indent-amount";
	private static final String FOUR = "4";
	
	public static void main(String[] args) {
		
		try {
			// DOM document
			Document document = DocumentBuilderFactory.newInstance().newDocumentBuilder().newDocument();
			
			// root element
			Element rootElement = document.createElement(COMPANY);
			document.appendChild(rootElement);
			
			// staff element
			Element staff = document.createElement(STAFF);
			rootElement.appendChild(staff);
			
			// set attribute of staff element
			staff.setAttribute(ID, ONE);
			
			// firstname element
			Element firstname = document.createElement(FIRST_NAME);
			firstname.appendChild(document.createTextNode(JOHN));
			staff.appendChild(firstname);
			
			// lastname element
			Element lastname = document.createElement(LAST_NAME);
			lastname.appendChild(document.createTextNode(DOE));
			staff.appendChild(lastname);
			
			// nickname element
			Element nickname = document.createElement(NICK_NAME);
			nickname.appendChild(document.createTextNode(JDOE));
			staff.appendChild(nickname);
			
			// salary element
			Element salary = document.createElement(SALARY);
			salary.appendChild(document.createTextNode(EIGHTY_THOUSAND));
			staff.appendChild(salary);
			
			// write the DOM tree into xml file
			Transformer transformer = TransformerFactory.newInstance().newTransformer();
			// format the xml output
			transformer.setOutputProperty(OutputKeys.INDENT, YES);
			transformer.setOutputProperty(INDENT_URL, FOUR);
			
			DOMSource source = new DOMSource(document);
			
			StreamResult result = new StreamResult(new File(FILE_PATH));
			
			transformer.transform(source, result);
			
			// print the result to Console
			transformer.transform(source, new StreamResult(System.out));		
		} catch (ParserConfigurationException pce) {
			pce.printStackTrace();
		} catch (TransformerException te) {
			te.printStackTrace();
		}
	}

}
