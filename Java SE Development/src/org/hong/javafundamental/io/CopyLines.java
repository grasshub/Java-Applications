package org.hong.javafundamental.io;


import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;

public class CopyLines {
	
	public static void main(String[] args) throws IOException {

		String line;
    	String inputName = "Java SE Development/Data File/FiftyMan.txt";

    	String outputName = "Java SE Development/Data File/OutFile.txt";

		try (BufferedReader in = new BufferedReader(new FileReader(inputName));
			 PrintWriter out = new PrintWriter(new BufferedWriter(new FileWriter(outputName)))) {

			while ((line = in.readLine()) != null) {
				out.println(line);
			}
		}

    }

}
