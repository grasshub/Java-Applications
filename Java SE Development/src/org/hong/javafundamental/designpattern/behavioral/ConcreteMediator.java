package org.hong.javafundamental.designpattern.behavioral;

public class ConcreteMediator implements Mediator {
	
	private BookButton bookButton;
	private ViewButton viewButton;
	private SearchButton searchButton;
	private LabelDisplay labelDisplay;
	
	public void registerBook(BookButton bookButton) {
		this.bookButton = bookButton;
	}
	
	public void registerView(ViewButton viewButton) {
		this.viewButton = viewButton;
	}
	
	public void registerSearch(SearchButton searchButton) {
		this.searchButton = searchButton;
	}
	
	public void registerDisplay(LabelDisplay labelDisplay) {
		this.labelDisplay = labelDisplay;
	}
	
	public void book() {
		bookButton.setEnabled(false);
		viewButton.setEnabled(true);
		searchButton.setEnabled(true);
		labelDisplay.setText("booking ...");
	}
	
	public void view() {
		bookButton.setEnabled(true);
		viewButton.setEnabled(false);
		searchButton.setEnabled(true);
		labelDisplay.setText("viewing ...");
	}
	
	public void search() {
		bookButton.setEnabled(true);
		viewButton.setEnabled(true);
		searchButton.setEnabled(false);
		labelDisplay.setText("searching ...");
	}

}
