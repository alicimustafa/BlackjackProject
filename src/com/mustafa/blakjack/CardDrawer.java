package com.mustafa.blakjack;

import java.util.List;

/**
 * @author mustafaalici
 * 
 * this class renders a nice ascii art
 * for card
 *
 */
public class CardDrawer {
	
	StringBuilder builder = new StringBuilder();
	
	/**
	 * @param card is Card object
	 * @return String that holds
	 * the ascii art for card
	 */
	public String drawFace(List<Card> cards, boolean dealer) {
		int size = cards.size();
		String dis;
		int ord; 
		int value;
		int startNumber = 0;
		
		StringBuilder line1 = new StringBuilder();
		StringBuilder line2 = new StringBuilder();
		StringBuilder line3 = new StringBuilder();
		StringBuilder line4 = new StringBuilder();
		StringBuilder line5 = new StringBuilder();
		StringBuilder line6 = new StringBuilder();
		StringBuilder line7 = new StringBuilder();
		if(dealer) {
			startNumber = 1;
			line1.append(" ________  ");
			line2.append("|    ___ | ");
			line3.append("|    | | | ");
			line4.append("| __ | | | ");
			line5.append("| \\____/ | ");
			line6.append("|        | ");
			line7.append("|________| ");
		}
		
		for(int i = startNumber; i < size; i++) {
			ord = cards.get(i).getRank().ordinal();
			value = cards.get(i).getRank().getValue()[0];
			dis = ord == 12? "A ": ord == 11 ? "K ": ord == 10 ? "Q ": ord == 9 ? "J ": ord == 8 ? "10" :" " + value ;
			line1.append(" ________  ");
			line2.append("|" + dis +"      | ");
			line3.append("|        | ");
			line4.append("|    " + cards.get(i).getSuit().unicodeVal + "   | ");
			line5.append("|        | ");
			line6.append("|      "+ dis +"| ");
			line7.append("|________| ");
		}
		builder.append(line1.append('\n'));
		builder.append(line2.append('\n'));
		builder.append(line3.append('\n'));
		builder.append(line4.append('\n'));
		builder.append(line5.append('\n'));
		builder.append(line6.append('\n'));
		builder.append(line7.append('\n'));
		return builder.toString();
	}
}
