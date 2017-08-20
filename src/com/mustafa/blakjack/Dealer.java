package com.mustafa.blakjack;

public class Dealer implements Actor {
	
	GameHand hand;
	
	public Dealer() {
		hand = new GameHand();
	}

	@Override
	public int makeMove() {
		if(hand.getHand().get(0).getRank().getValue()[0] + hand.getHand().get(1).getRank().getValue()[0] == 21) {
			return 0;
		}
		if(hand.getValueOfHand() <= 17 || hand.getSoftValue() < 18) {
			return 1;
		}
		return 0;
	}

	@Override
	public void takeCard(Card card) {
		hand.addCard(card);

	}

	public GameHand getHand() {
		return hand;
	}

}
