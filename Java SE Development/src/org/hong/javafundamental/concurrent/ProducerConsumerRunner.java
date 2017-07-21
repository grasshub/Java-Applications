package org.hong.javafundamental.concurrent;

public class ProducerConsumerRunner {
	
	public static void main(String[] args) {
		
		MessageBox messageBox = new MessageBox();
		
		(new Thread(new Producer(messageBox))).start();
		(new Thread(new Consumer(messageBox))).start();
	}

}
