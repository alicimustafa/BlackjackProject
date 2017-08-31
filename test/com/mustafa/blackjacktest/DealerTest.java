package com.mustafa.blackjacktest;

import static org.junit.Assert.*;

import java.util.Scanner;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import com.mustafa.blakjack.Card;
import com.mustafa.blakjack.Dealer;
import com.mustafa.blakjack.Rank;
import com.mustafa.blakjack.Suit;

public class DealerTest {
	
	Dealer d;
	Card c1, c2, c3, c4, c5, c6;
	Scanner keyboard = new Scanner(System.in);
	
	@Before
	public void setUp() throws Exception {
		d = new Dealer();
		c1 = new Card(Suit.CLUB, Rank.ACE);
		c2 = new Card(Suit.CLUB, Rank.JACK);
		c3 = new Card(Suit.CLUB, Rank.THREE);
		c4 = new Card(Suit.CLUB, Rank.FIVE);
		c5 = new Card(Suit.CLUB, Rank.EIGHT);
		c6 = new Card(Suit.CLUB, Rank.SIX);
	}

	@After
	public void tearDown() throws Exception {
		d = null;
	}

	@Test
	public void test_makeMove_to_check_dealer_to_stop_at_Blackjack() {
		d.takeCard(c1);
		d.takeCard(c2);
		assertEquals(0 , d.makeMove(keyboard));
	}
	
	@Test
	public void test_makeMove_check_dealers_stops_at_17() {
		d.takeCard(c2);
		d.takeCard(c4);
		assertEquals(1 , d.makeMove(keyboard));
		d.takeCard(c3);
		assertEquals(0 , d.makeMove(keyboard));
	}
	
	@Test
	public void test_makeMove_does_dealer_hit_on_soft_17() {
		d.takeCard(c2);
		d.takeCard(c6);
		assertEquals(1 , d.makeMove(keyboard));
	}
	
	@Test
	public void test_deckHasAce_shows_if_there_is_ace() {
		d.takeCard(c1);
		d.takeCard(c6);
		d.takeCard(c4);
		assertTrue(d.deckHasAce());
	}
	
	@Test
	public void test_deckHasAce_shows_no_ace() {
		d.takeCard(c2);
		d.takeCard(c6);
		d.takeCard(c4);
		assertFalse(d.deckHasAce());
		
	}

}
