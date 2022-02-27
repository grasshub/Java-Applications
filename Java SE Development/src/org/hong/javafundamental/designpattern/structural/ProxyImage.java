package org.hong.javafundamental.designpattern.structural;

public class ProxyImage implements Image {
	
	private Image image;
	private final String fileName;
	
	public ProxyImage(String fileName) {
		this.fileName = fileName;
	}
	
	public void displayImage() {
		if (image == null) 
			image = new ConcreteImage(fileName);
		
		image.displayImage();
			
	}
	
}
