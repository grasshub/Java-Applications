package org.hong.javafundamental.io;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

public class CopyBytes {
	
    public static void main(String[] args) throws IOException {

		String inputName = "Java SE Development/Data File/FiftyMan.txt";
    	String outputName = "Java SE Development/Data File/OutFile.txt";

		try (FileInputStream in = new FileInputStream(inputName);
			 FileOutputStream out = new FileOutputStream(outputName)) {
			int c;

			while ((c = in.read()) != -1) {
				System.out.println((char) c);
				out.write(c);
			}
		}

    }
    
}