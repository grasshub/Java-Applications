package org.hong.javafundamental.regex;

public class PatternConfigRunner {
	
	public static void main(String[] args) {
		
		String input = "My dog is Blue.\n" +
				"He is not red or green.";

		Boolean controlResult = input.matches("(?=.*Green).*Blue.*");
		Boolean caseInsensitiveResult = input.matches("(?i)(?=.*Green).*Blue.*");
		Boolean dotallResult = input.matches("(?s)(?=.*Green).*Blue.*");
		Boolean configuredResult = input.matches("(?is)(?=.*Green).*Blue.*");
		
		System.out.println("Control result was: " + controlResult);
		System.out.println("Case ins. result was: " + caseInsensitiveResult);
		System.out.println("Dot-all result was: " + dotallResult);
		System.out.println("Configured result was: " + configuredResult);
	}

}
