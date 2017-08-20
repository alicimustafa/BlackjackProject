package com.mustafa.blackjacktest;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

import java.util.List;

import org.junit.Test;

import com.mustafa.blakjack.Card;
import com.mustafa.blakjack.DeckGenerator;
import com.mustafa.blakjack.Rank;
import com.mustafa.blakjack.Suit;

public class DeckGeneratorTest {
	
	

	@Test
	public void test_getDeck_to_see_if_return_list_of_52_card() {
		List<Card> deck = DeckGenerator.getDeck(Rank.values(), Suit.values(), 1);
		assertEquals( 52 , deck.size());
	}
	
	@Test
	public void test_getDeck_to_see_if_generated_correct_cards() {
		List<Card> deck = DeckGenerator.getDeck(Rank.values(), Suit.values(), 1);
		assertTrue(Rank.TWO == deck.get(0).getRank() && Suit.SPADE == deck.get(0).getSuit());
		assertTrue(Rank.FIVE == deck.get(15).getRank() && Suit.CLUB == deck.get(15).getSuit());
		assertTrue(Rank.TEN == deck.get(33).getRank() && Suit.HEART == deck.get(33).getSuit());
		assertTrue(Rank.ACE == deck.get(50).getRank() && Suit.DIAMOND == deck.get(50).getSuit());
		
	}

}
