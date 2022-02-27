package org.hong.javafundamental.designpattern.structural;

import java.util.Arrays;
import java.util.List;

public class Client {
	
	private final IAdapter adapter;
	
	public Client(IAdapter adapter) {
		this.adapter = adapter;
	}
	
	public void printList(List<String> stringList) {
		adapter.printList(stringList);
	}
	
	public static void main(String[] args) {
		Client client = new Client(new Adapter());
		List<String> stringList = Arrays.asList("First String", "Second String", "Third String");
		client.printList(stringList);
	}
	
}
