package org.hong.javafundamental.regex;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.util.regex.PatternSyntaxException;

public class RegexTestHarness {
	
	private static final String REGEX_PROMPT = "Enter your regular expression:";
	private static final String INPUT_PROMPT = "Enter input string to search:";
	private static final String RESULT_FORMAT = "I found the text" +
			" \"%s\" starting at " +
			"index %d and ending at index %d.%n";
	private static final String NO_MATCH =  "No match found";
	
	public static void main(String[] args) {

		BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

		while (true) {

			Pattern pattern;
			Matcher matcher;

			try {
				System.out.println(REGEX_PROMPT);
				pattern = Pattern.compile(reader.readLine());

				System.out.println(INPUT_PROMPT);
				matcher = pattern.matcher(reader.readLine());

				boolean found = false;
				//while (matcher.find()) {
				if (matcher.matches()) {
					System.out.printf(RESULT_FORMAT,
							matcher.group(),
							matcher.start(),
							matcher.end());
					found = true;
				}

				if(!found){
					System.out.println(NO_MATCH);
				}
			}catch (IOException ex) {
				System.err.println(ex.getMessage());
				// In order to avoid program to exit with incorrect regex syntax to catch this unchecked exception
			} catch (PatternSyntaxException ex) {
				System.err.println(ex.getMessage());
			}
		}
	}

}
