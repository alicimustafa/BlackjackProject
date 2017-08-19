package com.mustafa.blakjack;

public class Card implements Comparable<Card> {
	private Suit suit;
	private Rank rank;

	public Card(Suit suit, Rank rank) {
		super();
		this.suit = suit;
		this.rank = rank;
	}

	public Suit getSuit() {
		return suit;
	}

	public Rank getRank() {
		return rank;
	}

	@Override
	public int compareTo(Card o) {
		if(this.rank.ordinal() > o.rank.ordinal()) {
			return 1;
		} else if(this.rank.ordinal() < o.rank.ordinal()) {
			return -1;
		} else {
			if(this.suit.ordinal() > o.suit.ordinal()) {
				return 1;
			} else if(this.suit.ordinal() < o.suit.ordinal()) {
				return -1;
			}
		}
		return 0;
	}

	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("Card [suit=");
		builder.append(suit);
		builder.append(", rank=");
		builder.append(rank);
		builder.append("]");
		return builder.toString();
	}
	
	
}
