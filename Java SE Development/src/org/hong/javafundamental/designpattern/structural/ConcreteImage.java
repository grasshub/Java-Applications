package org.hong.javafundamental.designpattern.structural;

import java.awt.Canvas;
import java.awt.Graphics;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.swing.JFrame;

public class ConcreteImage extends Canvas implements Image {
	
	private static final long serialVersionUID = 7892619719662616594L;
	private String fileName;
	private BufferedImage image;
	private JFrame frame = null;
	
	public ConcreteImage(String fileName) {
		this.fileName = fileName;
		loadImageFromDisk();
	}
	
	private void loadImageFromDisk() {
		try {
			image = ImageIO.read(new File("Image Files/" + fileName));
			System.out.println("Loading the image from " + fileName);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	public void paint(Graphics graphics) {
		graphics.drawImage(image, 0, 0, null);
	}
	
	public void displayImage() {
		if (frame == null)
		{
			frame = new JFrame("Display Image: " + fileName);
			frame.setSize(400, 400);
			frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
			frame.getContentPane().add(this, "Center");
			frame.setVisible(true);
		}
		else
			frame.setVisible(true);
	}

}
