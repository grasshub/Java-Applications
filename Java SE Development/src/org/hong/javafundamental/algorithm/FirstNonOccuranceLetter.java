package org.hong.javafundamental.algorithm;

public class FirstNonOccuranceLetter {

	public static void main(String[] args) {
		String word = "google";
    	
    	for (int index = 0; index < word.length(); index++) {
    		// loop through each character in string
    		String character = word.substring(index, index + 1);
    		
    		// Remove the current character from string
    		String wordWithoutCurrentCharacter = word.substring(0, index).concat(word.substring(index + 1));
    		    		
    		if (!wordWithoutCurrentCharacter.contains(character)) {
    			System.out.println("The fist non occurance character in word " + character);
    			break;
    		} 		
    	}
    	
    	StringBuilder wordBuilder = new StringBuilder(word);
    	StringBuilder removedCharactersBuilder = new StringBuilder();
    	
    	while (wordBuilder.length() > 0) {
    		String character = wordBuilder.substring(0, 1);
    		
    		wordBuilder.deleteCharAt(0);
    		
    		// Validate first character doesn't exist at wordBuilder and removedCharactersBuilder
    		if (!wordBuilder.toString().contains(character) && !removedCharactersBuilder.toString().contains(character)) {
    		    System.out.println("The fist non occurance character in word " + character);
    			break;
    		}
    		else {
    			// Add the removed first character in workBuilder to removedCharactersBuilder for next validation
    			removedCharactersBuilder.append(character);
    		}
    	}
	}

}
