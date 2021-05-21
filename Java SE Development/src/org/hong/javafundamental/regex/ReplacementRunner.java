package org.hong.javafundamental.regex;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class ReplacementRunner {

	private static final String INPUT = "aabfooabfooaaabfoob";

	public static void main(String[] args) {

		final String REGEX = "a*b";
		Pattern pattern = Pattern.compile(REGEX);
		Matcher matcher = pattern.matcher(INPUT);
		final String REPLACE = "-";
		final String INPUT = matcher.replaceAll(REPLACE);
		
		System.out.println(INPUT);
	}

}
