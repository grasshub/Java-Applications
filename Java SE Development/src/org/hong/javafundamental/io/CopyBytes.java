package org.hong.javafundamental.io;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

public class CopyBytes {
	
    public static void main(String[] args) throws IOException {

    	FileInputStream in = null;
    	FileOutputStream out = null;
    	String inputName = "Data File/FiftyMan.txt";
    	String outputName = "Data File/OutFile.txt";

    	try {
    		in = new FileInputStream(inputName);
    		out = new FileOutputStream(outputName);
    		int c;

    		while ((c = in.read()) != -1) {
        		System.out.println((char)c);
    			out.write(c);
    		}
    	} finally {
    		if (in != null) {
    			in.close();
    		}
    		if (out != null) {
    			out.close();
    		}
    	}

    }
    
}