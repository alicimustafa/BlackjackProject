package com.mustafa.blakjack;

/**
 * @author mustafaalici
 * enum holds the rank for the cards
 * and values
 */
public enum Rank {
	TWO(new int[]{2}),
	THREE(new int[]{3}),
	FOUR(new int[]{4}),
	FIVE(new int[]{5}),
	SIX(new int[]{6}),
	SEVEN(new int[]{7}),
	EIGHT(new int[]{8}),
	NINE(new int[]{9}),
	TEN(new int[]{10}),
	JACK(new int[]{10}),
	QUEEN(new int[]{10}),
	KING(new int[]{10}),
	ACE(new int[]{11,1});
	
	int[] value;

	private Rank(int[] value) {
		this.value = value;
	}
	
}
