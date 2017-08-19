package com.mustafa.blakjack;

/**
 * @author mustafaalici
 * 
 * this class renders a nice ascii art
 * for card
 *
 */
public class CardDrawer {
	
	/**
	 * @param card is Card object
	 * @return String that holds
	 * the ascii art for card
	 */
	public String drawFace(Card card) {
		int ord =card.getRank().ordinal();
		String dis; 
		dis 	= ord == 12? "A ": ord == 11 ? "K ": ord == 10 ? "Q ": ord == 9 ? "J ": ord == 8 ? "10" :" " +card.getRank().getValue()[0] ;
		
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
	
	public String drawBack() {
		StringBuilder builder = new StringBuilder();
		builder.append(" ________\n");
		builder.append("|    ___ |\n");
		builder.append("|    | | |\n");
		builder.append("| __ | | |\n");
		builder.append("| \\____/ |\n");
		builder.append("|        |\n");
		builder.append("|________|\n");
		return builder.toString();
	}

}
