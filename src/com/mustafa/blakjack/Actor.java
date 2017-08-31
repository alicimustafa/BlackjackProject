package com.mustafa.blakjack;

import java.util.Scanner;

public interface Actor {
	
	int makeMove(Scanner keyboard);
	void  takeCard(Card card);
	GameHand getHand();
	
}
