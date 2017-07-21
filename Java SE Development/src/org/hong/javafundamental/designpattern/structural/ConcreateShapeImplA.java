package org.hong.javafundamental.designpattern.structural;

import java.awt.Canvas;
import java.awt.Color;
import java.awt.Graphics;

import javax.swing.JFrame;

public class ConcreateShapeImplA extends Canvas implements ShapeImplementation {
	
	private static final long serialVersionUID = 4459318671013398245L;
	private boolean drawCircle = false;
	private boolean drawSquare = false;
	private double x;
	private double y;
	private double radius;
	private double width;
	private double height;
	
	public void paint(Graphics graphics) {
		
		if (drawCircle) {
			graphics.setColor(Color.yellow);
			graphics.fillOval((int)(x - radius), (int)(y - radius), (int)(radius * 2), (int)(radius * 2));
			graphics.setColor(Color.red);
			graphics.drawOval((int)(x - radius), (int)(y - radius), (int)(radius * 2), (int)(radius * 2));
		}
		
		if (drawSquare) {
			graphics.setColor(Color.orange);
			graphics.fillRect((int)x, (int)y, (int)width, (int)height);
			graphics.setColor(Color.blue);
			graphics.drawRect((int)x, (int)y, (int)width, (int)height);	
		}
	}
	
	private void prepareDraw() {
		
		JFrame frame = new JFrame();
		frame.setSize(400, 400);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().add(this);
		frame.setVisible(true);
	}
	
	public void draw(double x, double y, double radius) {
		
		prepareDraw();	
		this.x = x;
		this.y = y;
		this.radius = radius;
		this.drawCircle = true;
	}
	
	public void draw(double x, double y, double width, double height) {
		
		prepareDraw();	
		this.x = x;
		this.y = y;
		this.width = width;
		this.height = height;
		this.drawSquare = true;
	}
}
