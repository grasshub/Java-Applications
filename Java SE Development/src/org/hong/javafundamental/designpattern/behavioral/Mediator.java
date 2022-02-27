package org.hong.javafundamental.designpattern.behavioral;

public interface Mediator {
	
	void book();
	void view();
	void search();
	void registerBook(BookButton bookButton);
	void registerView(ViewButton viewButton);
	void registerSearch(SearchButton searchButton);
	
	void registerDisplay(LabelDisplay labelDisplay);

}
