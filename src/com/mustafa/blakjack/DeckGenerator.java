package com.mustafa.blakjack;

import java.util.ArrayList;
import java.util.List;

/**
 * @author mustafaalici this a class that used for generating decks
 */
public class DeckGenerator {

	/**
	 * @param rank
	 *            Rank array for building the deck
	 * @param suit
	 *            Suit array for building the deck
	 * @param how
	 *            many decks to generate
	 * @return array list containing deck of cards
	 */
	static public List<Card> getDeck(Rank[] rank, Suit[] suit, int howMany) {
		List<Card> deck = new ArrayList<>();
		for (int i = 0; i < howMany; i++) {
			for (Rank rnk : rank) {
				for (Suit st : suit) {
					deck.add(new Card(st, rnk));
				}
			}
		}
		return deck;
	}
}
