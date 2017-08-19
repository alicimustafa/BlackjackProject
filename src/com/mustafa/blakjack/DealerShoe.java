package com.mustafa.blakjack;

import java.util.Collections;
import java.util.List;

public class DealerShoe {
	
	private List<Card> cardDeck;
	private int delta;
	
	public DealerShoe(List<Card> setDecks) {
		cardDeck = setDecks;
		this.delta = cardDeck.size() / 4;
	}

	public int getDelta() {
		return delta;
	}
	
	public List<Card> getCardDeck() {
		return cardDeck;
	}

	public void shuffleDeck() {
		Collections.shuffle(cardDeck);
	}
	public Card drawCard() {
		return cardDeck.remove(0);
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((cardDeck == null) ? 0 : cardDeck.hashCode());
		result = prime * result + delta;
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
		DealerShoe other = (DealerShoe) obj;
		if (cardDeck == null) {
			if (other.cardDeck != null)
				return false;
		} else if (!cardDeck.equals(other.cardDeck))
			return false;
		if (delta != other.delta)
			return false;
		return true;
	}

	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("DealerShoe [cardDeck=");
		builder.append(cardDeck);
		builder.append(", delta=");
		builder.append(delta);
		builder.append("]");
		return builder.toString();
	}
	
	
}
