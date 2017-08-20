package com.mustafa.blakjack;

public interface Actor {
	
	int makeMove();
	void  takeCard(Card card);
	GameHand getHand();
	
}
