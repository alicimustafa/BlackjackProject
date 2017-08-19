package com.mustafa.blakjack;

public class CardDrawer {
	
	public String draw(Card card) {
		String dis = card.getRank().value[0] == 11? "A": "" +card.getRank().value[0];
		StringBuilder builder = new StringBuilder();
		builder.append(" ________");
		builder.append("| " + dis +"      |");
		builder.append("|        |");
		builder.append("|    " + card.getSuit().unicodeVal + "    |");
		builder.append("|        |");
		builder.append("|       "+ dis +" |");
		builder.append("|________|");
		return builder.toString();
	}

}
