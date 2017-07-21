package org.hong.javafundamental.designpattern.structural;

import java.util.ArrayList;
import java.util.List;

public class CompositeGraphic implements Graphic {
	
	private List<Graphic> childGraphics = new ArrayList<Graphic>();
	
	public void add(Graphic graphic) {
		childGraphics.add(graphic);
	}
	
	private void dispose(CompositeGraphic compositeGraphic) {
		compositeGraphic = null;
	}
	
	public void remove(Graphic graphic) {
		
		if (childGraphics.contains(graphic)) {
			childGraphics.remove(graphic);
			// need to remove composite with no child
			// TODO could not dispose the object when it's method is not completed
			if (childGraphics.isEmpty())
				dispose(this);
		}
		else 
			for (Graphic graph : childGraphics) 
				graph.remove(graphic);
	}
	
	public void print() {
		for (Graphic graphic: childGraphics ) {
			graphic.print();
		}
	}
	
	

}
