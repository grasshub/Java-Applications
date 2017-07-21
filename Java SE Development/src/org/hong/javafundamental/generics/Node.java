package org.hong.javafundamental.generics;

public class Node<T> {

	protected T data;
	// Cannot declare static field with type parameter
	//private static T s;

	public Node(T data) {
		this.data = data;
	}
	
	public T getData() {
		return data;
	}

	public void setData(T data) {
		System.out.println("Node.setData");
		this.data = data;
	}
}
