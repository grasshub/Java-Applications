package org.hong.javafundamental.regex;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class PatternPlacement {
	
	private static final String INPUT =  "User clientId=23421. Some more text clientId=33432. This clientNum=100";
	private static final String PATTERN = "((clientId=)(\\d+)|(clientNum=)(\\d+))";
	private static final String CLIENT_ID = "clientId";
	private static final String CLIENT_NUM = "clientNum";
	private static final String MASK = "***masked***";
		
	public static void main(String[] args) {
		
		Pattern p = Pattern.compile(PATTERN);
		Matcher m = p.matcher(INPUT);
		
		StringBuffer result = new StringBuffer();
		while(m.find()) {
			if (m.group().contains(CLIENT_ID)) {
				System.out.println("Masking: " + m.group(3));
				m.appendReplacement(result, "$2" + MASK);
			}
			else if (m.group().contains(CLIENT_NUM)) {
				System.out.println("Masking: " + m.group(5));
				m.appendReplacement(result, "$4" + MASK);
			}				
		}
		m.appendTail(result);
		System.out.println(result);
	}

}
