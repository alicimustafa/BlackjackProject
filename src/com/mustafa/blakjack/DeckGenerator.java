package com.mustafa.blakjack;

import java.util.ArrayList;
import java.util.List;

/**
 * @author mustafaalici
 * this a class that used for generating 
 * decks
 */
public class DeckGenerator {
	
	/**
	 * @param rank Rank array for building the deck
	 * @param suit Suit array for building the deck
	 * @return array list containing deck of cards
	 */
	static public List<Card> getDeck(Rank[] rank, Suit[] suit) {
		List<Card> deck = new ArrayList<>();
		for (Rank rnk : rank) {
			for(Suit st: suit) {
				deck.add(new Card(st, rnk));
			}
		}
		return deck;
	}
}
