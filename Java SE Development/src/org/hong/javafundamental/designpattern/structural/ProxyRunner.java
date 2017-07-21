package org.hong.javafundamental.designpattern.structural;

public class ProxyRunner {
	
	public static void main(String[] args) {
		Image proxyImage1 = new ProxyImage("Monkey.gif");
		Image proxyImage2 = new ProxyImage("Elephant.jpg");
		
		proxyImage1.displayImage();
		proxyImage1.displayImage();
		
		proxyImage2.displayImage();
		proxyImage2.displayImage();
		
		proxyImage1.displayImage();
	}

}
