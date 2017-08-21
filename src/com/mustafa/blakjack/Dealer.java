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
		if(hand.getValueOfHand() == 17 && deckHasAce()) {
			return 0;
		} else if(hand.getValueOfHand() < 17) {
			return 1;
		}
		return 0;
	}

	@Override
	public void takeCard(Card card) {
		hand.addCard(card);

	}
	
	public boolean deckHasAce() {
		boolean ace = false;
		for(Card card: hand.getHand()) {
			if(card.getRank().ordinal() == 12) {
				ace = true;
			}
		}
		return ace;
	}

	public GameHand getHand() {
		return hand;
	}

	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("Dealer [hand=");
		builder.append(hand);
		builder.append("]");
		return builder.toString();
	}
	
	

}
