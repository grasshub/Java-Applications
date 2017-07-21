package org.hong.javafundamental.exception;

import java.io.*;
import java.util.List;
import java.util.ArrayList;

public class ListOfNumbers {

    private List<Integer> list;
    private static final int SIZE = 10;
    private static final String fileName = "Data File/OutFile.txt";

    public ListOfNumbers () {
        list = new ArrayList<Integer>(SIZE);
        for (int i = 0; i < SIZE; i++) {
            list.add(new Integer(i));
        }
    }

    public void writeList() {
    	
    	PrintWriter out = null;

    	try {
    		System.out.println("Entering" + " try statement");
    		out = new PrintWriter(new FileWriter(fileName));

    		for (int i = 0; i < SIZE; i++) {
    			out.println("Value at: " + i + " = " + list.get(i));
    		}
    	} catch (FileNotFoundException e) {
    		System.out.println("Caught FileNotFoundExcpetion: " + e.getMessage());
    	} catch (IOException e) {
    		System.out.println("Caught IOExcpetion: " + e.getMessage());
    	} finally {
    		if (out != null) {
    			System.out.println("Closing PrintWriter resource!");
    			out.close();
    		}
    	}
    }
    
    public void writeListWithResource() {

    	try (PrintWriter out = new PrintWriter(new FileWriter(fileName))) {
    		System.out.println("Entering" + " try statement");
    		for (int i = 0; i < SIZE; i++) {
    			out.println("Value at: " + i + " = " + list.get(i));
    		}
    	} catch (FileNotFoundException e) {
    		System.out.println("Caught FileNotFoundExcpetion: " + e.getMessage());
    	} catch (IOException e) {
    		System.out.println("Caught IOExcpetion: " + e.getMessage());
    	} 
    }
    
    public static void main (String[] args) {
    	ListOfNumbers nums = new ListOfNumbers();
    	nums.writeList(); 
    	nums.writeListWithResource();
    }
    
}