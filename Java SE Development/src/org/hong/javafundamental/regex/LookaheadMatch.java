package org.hong.javafundamental.regex;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class LookaheadMatch {
	
	// Pattern for valid password containing 8-12 alphanumeric characters, and at least two numbers in any position
	private static final String PATTERN = "(?=.*[0-9].*[0-9])[0-9a-zA-Z]{8,12}";
	private static final String PROMPT = "Enter password to validate:";
	private static final String VALID_FORMAT = "\"%s\" is valid password%n";
	private static final String INVALID_FORMAT = "\"%s\" is not valid password%n";
	
	public static void main(String[] args) {

		BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

		Pattern pattern = Pattern.compile(PATTERN);

		while (true) {   

			System.out.println(PROMPT);
			Matcher matcher;
			String password;
			try {
				matcher = pattern.matcher((password = reader.readLine()));

				if (matcher.matches()) {
					System.out.printf(VALID_FORMAT, password);				
				}
				else {
					System.out.printf(INVALID_FORMAT, password);
				}

			} catch (IOException ex) {
				System.err.println(ex.getMessage());
			}  
		}
	}

}
