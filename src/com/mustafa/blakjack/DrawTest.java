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
		List<Card> deck = DeckGenerator.getDeck(Rank.values(), Suit.values(), 1);
		
		System.out.println(c.drawFace(deck, false));
		System.out.println(c.drawFace(deck, true));
	}
	


}
