package com.mustafa.blackjacktest;

import static org.junit.Assert.*;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import com.mustafa.blakjack.Card;
import com.mustafa.blakjack.GameHand;
import com.mustafa.blakjack.Rank;
import com.mustafa.blakjack.Suit;

public class GameHandTest {
	
	GameHand gh;
	Card c1, c2, c3;
	
	@Before
	public void setUp() throws Exception {
		gh = new GameHand();
		c1 = new Card(Suit.CLUB, Rank.ACE);
		c2 = new Card(Suit.CLUB, Rank.FIVE);
		c3 = new Card(Suit.CLUB, Rank.JACK);
		
	}

	@After
	public void tearDown() throws Exception {
		gh = null;
		c1 = null;
		c2 = null;
		c3 = null;
	}

	@Test
	public void test_GameHand_to_see_if_cards_get_added() {
		gh.addCard(c1);
		assertEquals( 1 ,gh.getHand().size());
		assertEquals( c1 ,gh.getHand().get(0));
		gh.addCard(c2);
		assertEquals( 2 ,gh.getHand().size());
		assertEquals( c2 , gh.getHand().get(1));
		gh.addCard(c3);
		assertEquals( 3 ,gh.getHand().size());
		assertEquals( c3 ,gh.getHand().get(2));
	}
	
	@Test
	public void test_getValueOfHand_check_if_value_correct() {
		gh.addCard(c1);
		gh.addCard(c2);
		gh.addCard(c3);
		assertEquals(26, gh.getValueOfHand());
		
	}
	
	@Test
	public void test_getSoftValueOfHand_check_if_value_correct() {
		gh.addCard(c1);
		gh.addCard(c2);
		gh.addCard(c3);
		assertEquals(16, gh.getValueOfHand());
		
	}

}
