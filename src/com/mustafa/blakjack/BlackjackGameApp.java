package com.mustafa.blakjack;

import java.util.ArrayList;
import java.util.List;
import java.util.MissingFormatArgumentException;
import java.util.Scanner;

public class BlackjackGameApp {

	List<Player> palayers;
	Dealer dealer;
	DealerShoe shoe;

	public static void main(String[] args) {
		Scanner keyboard = new Scanner(System.in);
		BlackjackGameApp game = new BlackjackGameApp(4);
		System.out.println("Welcome to Black Jack");

		int input = 0;
		do {
			try {
				System.out.println("How many players (1-6)");
				input = keyboard.nextInt();
			} catch (MissingFormatArgumentException e) {
				System.out.println("you must enter a number");
			}

		} while (input > 0 || input < 7);
		game.gameStart(input, keyboard);

	}

	public BlackjackGameApp(int numDecks) {
		palayers = new ArrayList<>();
		dealer = new Dealer();
		List<Card> setDecks = DeckGenerator.getDeck(Rank.values(), Suit.values(), numDecks);
		shoe = new DealerShoe(setDecks);
		shoe.shuffleDeck();
	}

	public void gameStart(int playerNum, Scanner keyboard) {
		for (int i = 0; i < playerNum; i++) {
			String name = keyboard.next();
			System.out.println("Enter player" + i);
			System.out.print("Name: ");
			this.palayers.add(new Player(name));
		}
		for (int i = 0; i < 2; i++) {
			for (Player player : palayers) {
				player.takeCard(shoe.drawCard());
			}
			dealer.takeCard(shoe.drawCard());
		}
	}
	
	public void drawBoard() {
		System.out.println("Dealer");
		System.out.println();
	}

}
