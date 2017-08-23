package com.mustafa.blakjack;

import java.util.ArrayList;
import java.util.List;

public class GameHand {
	private List<Card> hand;
	private double bet;

	public GameHand() {
		hand = new ArrayList<>();
	}

	public double getBet() {
		return bet;
	}

	public void setBet(double bet) {
		this.bet = bet;
	}

	public List<Card> getHand() {
		return hand;
	}

	public void addCard(Card card) {
		hand.add(card);
	}

	public int getValueOfHand() {
		int value = 0;
		for (Card card : hand) {
			value += card.getRank().getValue()[0];
		}

		return value;
	}

	public int getSoftValue() {
		int value = 0;
		for (Card card : hand) {
			value += card.getRank().ordinal() == 12 ? card.getRank().getValue()[1]: card.getRank().getValue()[0];
		}
		return value;
	}
	
	public boolean checkIfPlayerBust() {
		int playerScore = getValueOfHand() > 21 ? getSoftValue() : getValueOfHand();
		return playerScore > 21;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((hand == null) ? 0 : hand.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		GameHand other = (GameHand) obj;
		if (hand == null) {
			if (other.hand != null)
				return false;
		} else if (!hand.equals(other.hand))
			return false;
		return true;
	}

	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("GameHand [hand=");
		builder.append(hand);
		builder.append("]");
		return builder.toString();
	}

}
