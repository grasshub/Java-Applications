package org.hong.javafundamental.algorithm;

import java.util.Arrays;
import java.util.logging.Level;
import java.util.logging.Logger;

public class FirstNonRepeatingLetter {
    static final Logger logger = Logger.getLogger(FirstNonRepeatingLetter.class.getName());

    public static char findNonRepeating(String str) {
        if (null == str || str.length() == 0)
            return (char) 0;

        var arr = new int[26];
        Arrays.fill(arr, 0);
        for (var i = 0; i < str.length(); i++) {
            arr[str.charAt(i) - 'a'] = arr[str.charAt(i) - 'a'] + 1;
        }

        for (var i = 0; i < str.length(); i++) {
            if (arr[str.charAt(i) - 'a'] == 1)
                return str.charAt(i);
        }
        return (char) 0;
    }

    public static void main(String[] args) {
        var word = "google";

        logger.log(Level.INFO, "{0}", findNonRepeating(word));
    }

//	 public static void main(String[] args) {
//		String word = "google";
//
//    	for (int index = 0; index < word.length(); index++) {
//    		// loop through each character in string
//    		String character = word.substring(index, index + 1);
//
//    		// Remove the current character from string
//    		String wordWithoutCurrentCharacter = word.substring(0, index).concat(word.substring(index + 1));
//
//    		if (!wordWithoutCurrentCharacter.contains(character)) {
//    			System.out.println("The fist non occurrence character in word " + character);
//    			break;
//    		}
//    	}
//
//    	StringBuilder wordBuilder = new StringBuilder(word);
//    	StringBuilder removedCharactersBuilder = new StringBuilder();
//
//    	while (wordBuilder.length() > 0) {
//    		String character = wordBuilder.substring(0, 1);
//
//    		wordBuilder.deleteCharAt(0);
//
//    		// Validate first character doesn't exist at wordBuilder and removedCharactersBuilder
//    		if (!wordBuilder.toString().contains(character) && !removedCharactersBuilder.toString().contains(character)) {
//    		    System.out.println("The fist non occurrence character in word " + character);
//    			break;
//    		}
//    		else {
//    			// Add the removed first character in workBuilder to removedCharactersBuilder for next validation
//    			removedCharactersBuilder.append(character);
//    		}
//    	}
//	}

}
