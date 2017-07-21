package org.hong.javafundamental.concurrent;

import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class MessageBuffer {
	
	private final int SIZE = 100;
	private final int ZERO = 0;
	// Messages sent from producer to consumer
	private final String[] messages = new String[SIZE];
	private int count;
	private int putIndex;
	private int takeIndex;
	
	private final Lock lock = new ReentrantLock();
	private final Condition notFull = lock.newCondition();
	private final Condition notEmpty = lock.newCondition();

	public String take() throws InterruptedException {
		
		lock.lock();
		
		try {
			// Wait until message is available
			while(count == ZERO)
				notEmpty.await();
			
			String message = messages[takeIndex];
			if (++takeIndex == messages.length)
				takeIndex = ZERO;
			count--;
			// Notify producer the status 
			notFull.signalAll();
			return message;	
		} finally {
			lock.unlock();
		}
	}
		
	public void put(String message) throws InterruptedException {

		lock.lock();
		
		try {
			// Wait until messages is not full
			while(count == messages.length)
				notFull.await();
			
			messages[putIndex] = message;
			if (++putIndex == messages.length)
				putIndex = ZERO;
			count++;
			// Notify consumer the status 
			notEmpty.signalAll();
		} finally {
			lock.unlock();
		}
	}

}
