package org.hong.javafundamental.api;

public class BooleanAPI {
	
	private static boolean yesOrNo(String string) {
		string = string.toLowerCase();
		
		if (string.equals("yes") || string.equals("y") || string.equals("true")
				|| string.equals("t")) {
			string = "true";
		}
		// It is a weird API, it will return true if system property of argument
		// name exist and value equals to string "true".
		return Boolean.getBoolean(string);
	}
	
	// revised version of method
	private static boolean yesNo(String string) {
		string = string.toLowerCase();
		
		return string.equals("yes") || string.equals("y") || string.equals("true")
				|| string.equals("t");
	}


	public static void main(String[] args) {
		// false false
		System.out.println(yesOrNo("true") + " " + yesOrNo("YeS"));
		// true true
		System.out.println(yesNo("true") + " " + yesNo("YeS"));
	}

}
