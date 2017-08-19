package com.mustafa.blakjack;

import java.util.ArrayList;
import java.util.List;

public class DeckGenerator {
	
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
