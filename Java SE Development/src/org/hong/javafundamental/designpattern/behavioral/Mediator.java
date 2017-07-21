package org.hong.javafundamental.designpattern.behavioral;

public interface Mediator {
	
	public void book();
	public void view();
	public void search();
	public void registerBook(BookButton bookButton);
	public void registerView(ViewButton viewButton);
	public void registerSearch(SearchButton searchButton);
	
	public void registerDisplay(LabelDisplay labelDisplay);

}
