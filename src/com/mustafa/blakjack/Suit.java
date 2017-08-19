package com.mustafa.blakjack;

public enum Suit {
	SPADE('\u2660'), HEART('\u2665'), DIAMOND('\u2665'), CLUB('\u2663');

	char unicodeVal;

	private Suit(char unicodeVal) {
		this.unicodeVal = unicodeVal;
	}

}
