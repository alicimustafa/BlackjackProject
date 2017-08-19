package com.mustafa.blakjack;

public class CardDrawer {
	
	public String draw(Card card) {
		int ord =card.getRank().ordinal();
		String dis; 
		dis 	= ord == 12? "A ": ord == 11 ? "K ": ord == 10 ? "Q ": ord == 9 ? "J ": ord == 8 ? "10" :" " +card.getRank().value[0] ;
		
		StringBuilder builder = new StringBuilder();
		builder.append(" ________\n");
		builder.append("|" + dis +"      |\n");
		builder.append("|        |\n");
		builder.append("|    " + card.getSuit().unicodeVal + "   |\n");
		builder.append("|        |\n");
		builder.append("|      "+ dis +"|\n");
		builder.append("|________|\n");
		return builder.toString();
	}

}
