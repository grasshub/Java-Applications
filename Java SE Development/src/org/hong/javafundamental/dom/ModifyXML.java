package org.hong.javafundamental.dom;

import java.io.File;
import java.io.IOException;

import javax.xml.parsers.DocumentBuilder;
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
import org.w3c.dom.NamedNodeMap;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;

public class ModifyXML {
	
	private static final String STAFF = "staff";
	private static final String ID = "id";
	private static final String AGE = "age";
	private static final String NICK_NAME = "nickname";
	private static final String SALARY = "salary";
	private static final String TWO = "2";
	private static final int ZERO = 0;
	private static final String NINETY_THOUSAND = "900000";
	private static final String FILE_PATH = "C:/mytemp/xmlOutput.xml";
	private static final String PATH = "C:/mytemp/xmlModified.xml";
	private static final String YES = "yes";
	private static final String INDENT_URL = "{http://xml.apache.org/xslt}indent-amount";
	private static final String FOUR = "4";
	private static final String FORTY = "40";
	
	public static void main(String[] args) {
		
		try {
			// DOM document
			DocumentBuilder documentBuilder = DocumentBuilderFactory.newInstance().newDocumentBuilder();
			Document document = documentBuilder.parse(FILE_PATH);
			
			// Get root element
			// Node company = document.getFirstChild();
			
			// Get the staff element, it might not working if tag has spaces or other weird characters in front.
			// It's better to use getElementsByTagName() to get it directly.
			Node staff = document.getElementsByTagName(STAFF).item(ZERO);
			
			// Update staff attribute
			NamedNodeMap attributes  = staff.getAttributes();
			Node nodeAttribute = attributes.getNamedItem(ID);
			nodeAttribute.setTextContent(TWO);
			
			// append a new element to staff
			Element age = document.createElement(AGE);
			age.appendChild(document.createTextNode(FORTY));
			staff.appendChild(age);
			
			// loop the staff child node
			NodeList nodes = staff.getChildNodes();
			
			for (int i = 0; i < nodes.getLength(); i++) {
				Node node = nodes.item(i);
				
				// get the salary element and update its value
				if (SALARY.equals(node.getNodeName())) {
					node.setTextContent(NINETY_THOUSAND);
				}
				
				// remove nickname
				if (NICK_NAME.equals(node.getNodeName())) 
					staff.removeChild(node);
			}
			
			// write the DOM tree into xml file
			Transformer transformer = TransformerFactory.newInstance().newTransformer();
			// format the xml output
			transformer.setOutputProperty(OutputKeys.INDENT, YES);
			transformer.setOutputProperty(INDENT_URL, FOUR);
			
			DOMSource source = new DOMSource(document);
			
			StreamResult result = new StreamResult(new File(PATH));
			
			transformer.transform(source, result);
			
			// print the result to Console
			transformer.transform(source, new StreamResult(System.out));		
		} catch (ParserConfigurationException pce) {
			pce.printStackTrace();
		} catch (TransformerException te) {
			te.printStackTrace();
		} catch (SAXException | IOException e) {
			e.printStackTrace();
		}
	}

}
