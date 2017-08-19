package com.mustafa.blackjacktest;


import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import com.mustafa.blakjack.Card;
import com.mustafa.blakjack.DealerShoe;
import com.mustafa.blakjack.DeckGenerator;
import com.mustafa.blakjack.Rank;
import com.mustafa.blakjack.Suit;

public class DealerShoeTest {
	
	DealerShoe ds;

	@Before
	public void setUp() throws Exception {
		ds = new DealerShoe(DeckGenerator.getDeck(Rank.values(), Suit.values()));
	}

	@After
	public void tearDown() throws Exception {
		ds = null;
	}

	@Test
	public void test_contructor_to_see_if_you_get_52_card_and_delta_13() {
		assertEquals(52, ds.getCardDeck().size());
		assertEquals(13, ds.getDelta());
	}
	
	@Test
	public void test_drawCard_to_see_it_returns_a_card() {
		Card card = ds.drawCard();
		assertEquals(51 , ds.getCardDeck().size());
		assertTrue(card instanceof Card);
	}

}
