package com.mustafa.blackjacktest;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import com.mustafa.blakjack.BlackjackGameApp;
import com.mustafa.blakjack.Card;
import com.mustafa.blakjack.Dealer;
import com.mustafa.blakjack.Player;
import com.mustafa.blakjack.Rank;
import com.mustafa.blakjack.Suit;

public class BlackjackGameAppTest {
	
	BlackjackGameApp bj;
	Card cA, cQ, c3, c4, c5, c6, c7, c8, c2, c10;

	@Before
	public void setUp() throws Exception {
		bj = new BlackjackGameApp();
		cA = new Card(Suit.CLUB, Rank.ACE);
		cQ = new Card(Suit.CLUB, Rank.QUEEN);
		c8 = new Card(Suit.CLUB, Rank.EIGHT);
		c7 = new Card(Suit.CLUB, Rank.SEVEN);
		c5 = new Card(Suit.CLUB, Rank.FIVE);
		c4 = new Card(Suit.CLUB, Rank.FOUR);
		c3 = new Card(Suit.CLUB, Rank.THREE);
		c2 = new Card(Suit.CLUB, Rank.TWO);
		c6 = new Card(Suit.CLUB, Rank.SIX);
		c10 = new Card(Suit.CLUB, Rank.TEN);
	}

	@After
	public void tearDown() throws Exception {
		bj = null;
		cA = null;
		cQ = null;
		c8 = null;
		c7 = null;
		c5 = null;
		c4 = null;
		c3 = null;
		c2 = null;
		c6 = null;
		c10 = null;
	}

	@Test
	public void test_checkIfPlayerBeatDealer_shows_player_lost_with_score_hand_over21_using_soft_player_tied() {
		Dealer d = bj.getDealer();
		Player p = new Player("j");
		
		d.takeCard(cA);
		d.takeCard(c8);
		d.takeCard(c8);
		d.takeCard(c3);
		
		p.takeCard(c10);
		p.takeCard(c10);
		assertFalse(bj.checkIfPlayerBeatDealer(p));
	}
	@Test
	public void test_checkIfPlayerBeatDealer_shows_player_lost_with_score_hand_over21_using_soft() {
		Dealer d = bj.getDealer();
		Player p = new Player("j");
		
		d.takeCard(cA);
		d.takeCard(c8);
		d.takeCard(c8);
		d.takeCard(c3);
		
		p.takeCard(c10);
		p.takeCard(c8);
		assertFalse(bj.checkIfPlayerBeatDealer(p));
	}
	@Test
	public void test_checkIfPlayerBeatDealer_shows_player_lost_with_score_hand_lesthen21_tied() {
		Dealer d = bj.getDealer();
		Player p = new Player("j");
		
		d.takeCard(cA);
		d.takeCard(c8);
		
		p.takeCard(c10);
		p.takeCard(c7);
		p.takeCard(c2);
		assertFalse(bj.checkIfPlayerBeatDealer(p));
	}
	@Test
	public void test_checkIfPlayerBeatDealer_shows_player_won_with_score_hand_over21_using_soft() {
		Dealer d = bj.getDealer();
		Player p = new Player("j");
		
		d.takeCard(cA);
		d.takeCard(c8);
		d.takeCard(c8);
		d.takeCard(c2);
		
		p.takeCard(c10);
		p.takeCard(c10);
		assertTrue(bj.checkIfPlayerBeatDealer(p));
	}
	@Test
	public void test_checkIfPlayerBeatDealer_shows_player_won_with_score_hand_lesthen21_tied() {
		Dealer d = bj.getDealer();
		Player p = new Player("j");
		
		d.takeCard(c8);
		d.takeCard(c8);
		
		p.takeCard(c10);
		p.takeCard(c7);
		p.takeCard(c2);
		assertTrue(bj.checkIfPlayerBeatDealer(p));
	}
	
}
