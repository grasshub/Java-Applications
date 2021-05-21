package org.hong.javafundamental.collection;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Deal {
	
	private static final int MINIMUM = 2;
	// Make a normal 52 card deck
	private static final String[] suit = new String [] {
		"Spades", "hearts", "diamonds", "clubs"
	};
	
	private static final String [] rank = new String[] {
		"2", "3", "4", "5", "6", "7", "8", "9", "10", "jack", "queen", "king", "ace"
	};
	
	private static final String USAGE = "Usage: Deal hands cards";
	private static final String ERROR = "Not enough cards.";
	
	// Pick up a hand of decks
	private static <E> List<E> dealHand(List<E> deck, int n) {
		int deckSize = deck.size();
		List<E> handView = deck.subList(deckSize - n, deckSize);
		List<E> hand = new ArrayList<>(handView);
		
		handView.clear();
		return hand;
	}

	public static void main(String[] args) {
		
		if (args.length < MINIMUM) {
			System.err.println(USAGE);
			return;
		}
		
		int numHands = Integer.parseInt(args[0]);
		int cardsPerHand = Integer.parseInt(args[1]);
		
		List<String> deck = new ArrayList<>();
		for (String s : suit)
			for (String value : rank) deck.add(value + " of " + s);
		
		if (numHands * cardsPerHand > deck.size()) {
			System.err.println(ERROR);
			return;
		}
		
		// Shuffle the deck
		Collections.shuffle(deck);
		
		for (int i = 0; i < numHands; i++) 
			System.out.println(dealHand(deck, cardsPerHand));	
	}
	
}
