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
	Card cA, c5, cJ, c3, c8;
	
	@Before
	public void setUp() throws Exception {
		gh = new GameHand();
		cA = new Card(Suit.CLUB, Rank.ACE);
		c5 = new Card(Suit.CLUB, Rank.FIVE);
		cJ = new Card(Suit.CLUB, Rank.JACK);
		c3 = new Card(Suit.CLUB, Rank.THREE);
		c8 = new Card(Suit.CLUB, Rank.EIGHT);
		
	}

	@After
	public void tearDown() throws Exception {
		gh = null;
		cA = null;
		c5 = null;
		cJ = null;
		c3 = null;
		c8 = null;
	}

	@Test
	public void test_GameHand_to_see_if_cards_get_added() {
		gh.addCard(cA);
		assertEquals( 1 ,gh.getHand().size());
		assertEquals( cA ,gh.getHand().get(0));
		gh.addCard(c5);
		assertEquals( 2 ,gh.getHand().size());
		assertEquals( c5 , gh.getHand().get(1));
		gh.addCard(cJ);
		assertEquals( 3 ,gh.getHand().size());
		assertEquals( cJ ,gh.getHand().get(2));
	}
	
	@Test
	public void test_getValueOfHand_check_if_value_correct() {
		gh.addCard(cA);
		gh.addCard(c5);
		gh.addCard(cJ);
		assertEquals(26, gh.getValueOfHand());
		
	}
	
	@Test
	public void test_getSoftValue_check_if_value_correct() {
		gh.addCard(cA);
		gh.addCard(c5);
		gh.addCard(cJ);
		assertEquals(16, gh.getSoftValue());
		
	}
	
	@Test 
	public void test_checkIfPlayerBust_should_return_true_total_above_21_without_ace() {
		gh.addCard(cJ);
		gh.addCard(c5);
		gh.addCard(c8);
		assertTrue(gh.checkIfPlayerBust());
	}
	@Test 
	public void test_checkIfPlayerBust_should_return_true_total_above_21_with_ace() {
		gh.addCard(cJ);
		gh.addCard(c5);
		gh.addCard(c8);
		gh.addCard(cA);
		assertTrue(gh.checkIfPlayerBust());
	}
	@Test 
	public void test_checkIfPlayerBust_should_return_false_total_under_21_with_ace() {
		gh.addCard(cJ);
		gh.addCard(c5);
		gh.addCard(cA);
		assertFalse(gh.checkIfPlayerBust());
	}
	@Test 
	public void test_checkIfPlayerBust_should_return_false_total_under_21_without_ace() {
		gh.addCard(cJ);
		gh.addCard(c5);
		gh.addCard(c3);
		assertFalse(gh.checkIfPlayerBust());
	}

}
