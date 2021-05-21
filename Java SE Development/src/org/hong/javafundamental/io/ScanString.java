package org.hong.javafundamental.io;

import java.io.*;
import java.util.Scanner;

public class ScanString {
	
    public static void main(String[] args) throws IOException {

        String inputName = "Data File/FiftyMan.txt";
        try (Scanner s = new Scanner(new BufferedReader(new FileReader(inputName)))) {
            // separate the token with comma
            s.useDelimiter(",\\s*");

            while (s.hasNext()) {
                System.out.println(s.next());
                System.out.println();
                System.out.println();
            }
        }
    }
}