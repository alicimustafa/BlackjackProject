package com.mustafa.blakjack;

import java.util.List;

/**
 * @author mustafaalici
 * this generates a deck and prints them out
 * to see how the cards look before using then 
 * in the game
 */
public class DrawTest {

	public static void main(String[] args) {
		CardDrawer c = new CardDrawer();
		List<Card> deck = DeckGenerator.getDeck(Rank.values(), Suit.values());
		for (Card card : deck) {
			System.out.println(c.draw(card));
		}
	}

}
