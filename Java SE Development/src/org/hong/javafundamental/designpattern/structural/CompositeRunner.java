package org.hong.javafundamental.designpattern.structural;

public class CompositeRunner {
	
	public static void main(String[] args) {
		
		//Initialize two ellipses and two rectangles
		Ellipse ellipse1 = new Ellipse();
		Ellipse ellipse2 = new Ellipse();
		Rectangle rectangle1 = new Rectangle();
		Rectangle rectangle2 = new Rectangle();
		
		CompositeGraphic compositeGraphic1 = new CompositeGraphic();
		CompositeGraphic compositeGraphic2 = new CompositeGraphic();
		CompositeGraphic compositeGraphic3 = new CompositeGraphic();
		
		compositeGraphic2.add(ellipse1);
		compositeGraphic2.add(rectangle1);
		compositeGraphic2.add(ellipse2);
		
		compositeGraphic3.add(rectangle2);
		
		compositeGraphic1.add(compositeGraphic2);
		compositeGraphic1.add(compositeGraphic3);
		
		//print the tree of graphics
		compositeGraphic1.print();	
		
		compositeGraphic1.remove(rectangle1);
		compositeGraphic1.remove(rectangle2);
		compositeGraphic1.remove(ellipse1);
		compositeGraphic1.remove(ellipse2);
		
		/*
		compositeGraphic2 = null;
		compositeGraphic3 = null;
		*/
			
		compositeGraphic1.print();
		
	}

}
