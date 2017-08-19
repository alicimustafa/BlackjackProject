package com.mustafa.blakjack;

public class Player implements Actor {
	
	private GameHand hand;

	
	
	public Player() {
		super();
		hand = new GameHand();
	}

	@Override
	public int makeMove() {
		
		return 0;
	}

	@Override
	public void takeCard(Card card) {
		
		
	}

	public GameHand getHand() {
		return hand;
	}
	
	
}
