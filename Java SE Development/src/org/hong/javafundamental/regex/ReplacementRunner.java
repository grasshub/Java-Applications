package org.hong.javafundamental.regex;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class ReplacementRunner {
	
	private static String REGEX = "a*b";
	private static String INPUT = "aabfooabfooaaabfoob";
	private static String REPLACE = "-";
	
	public static void main(String[] args) {
		
		Pattern pattern = Pattern.compile(REGEX);
		Matcher matcher = pattern.matcher(INPUT);
		INPUT = matcher.replaceAll(REPLACE);
		
		System.out.println(INPUT);
	}

}
