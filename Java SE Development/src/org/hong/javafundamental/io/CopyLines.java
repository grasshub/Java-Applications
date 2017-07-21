package org.hong.javafundamental.io;


import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;

public class CopyLines {
	
	public static void main(String[] args) throws IOException {

    	BufferedReader in = null;
    	PrintWriter out = null;
    	String line;
    	String inputName = "Data File/FiftyMan.txt";

    	String outputName = "Data File/OutFile.txt";

    	try {
    		in = new BufferedReader(new FileReader(inputName));
    		out = new PrintWriter(new BufferedWriter(new FileWriter(outputName)));

    		while ((line = in.readLine()) != null) {
    			out.println(line);
    		}
    	}
    	finally {
    		if (in != null) {
    			in.close();
    		}
    		if (out != null) {
    			out.close();
    		}
    	} 

    }

}
