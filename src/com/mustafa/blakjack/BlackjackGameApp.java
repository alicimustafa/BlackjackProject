package com.mustafa.blakjack;

import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.List;
import java.util.Scanner;

/**
 * @author mustafaalici this the main class that runs whole game
 */
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
			} catch (InputMismatchException e) {
				System.out.println("you must enter a number");
				keyboard.nextLine();
			}

		} while (input < 1 || input > 6);
		game.gameStart(input, keyboard);
	}

	/**
	 * @param numDecks
	 *            number of decks to be generated this is the constructor for the
	 *            main app it fill the dealer shoe with card and suffles it
	 */
	public BlackjackGameApp(int numDecks) {
		palayers = new ArrayList<>();
		dealer = new Dealer();
		List<Card> setDecks = DeckGenerator.getDeck(Rank.values(), Suit.values(), numDecks);
		shoe = new DealerShoe(setDecks);
		shoe.shuffleDeck();
	}

	/**
	 * @param playerNum
	 *            number players vs the dealer
	 * @param keyboard
	 *            this stars the whole thing generating player
	 */
	public void gameStart(int playerNum, Scanner keyboard) {
		for (int i = 0; i < playerNum; i++) {
			System.out.println("Enter player" + (i + 1));
			System.out.print("Name: ");
			String name = keyboard.next();
			this.palayers.add(new Player(name));
		}
		for (int i = 0; i < 2; i++) {
			for (Player player : palayers) {
				player.takeCard(shoe.drawCard());
			}
			dealer.takeCard(shoe.drawCard());
		}
		drawBoard();

	}

	public boolean  runPlayerTurn(Player player) {
		CardDrawer draw = new CardDrawer();
		int playerResponse = 1;
		System.out.println(player.getName() + " this is your turn");
		do {
			System.out.println("Dealer");
			System.out.println(draw.drawFace(dealer.getHand().getHand(), true));
			System.out.println(player.getName());
			System.out.println(draw.drawFace(player.getHand().getHand(), true));
			playerResponse = player.makeMove();
			if(playerResponse == 1) {
				player.takeCard(shoe.drawCard());
				
			}
			
		} while (playerResponse == 1);
		return true;

	}
	
	public boolean checkIfPlayerBust(Player player) {
		int playerScore = player.getHand().getValueOfHand() > 21 ? player.getHand().getSoftValue()
				: player.getHand().getValueOfHand();
		return playerScore > 21;
	}

	/**
	 * this draws the ascii art for all of the player and dealer representing cards
	 * 
	 */
	public void drawBoard() {
		CardDrawer draw = new CardDrawer();
		System.out.println("Dealer");
		System.out.println(draw.drawFace(dealer.getHand().getHand(), true));
		for (Player player : palayers) {
			System.out.println("Player: " + player.getName());
			System.out.println(draw.drawFace(player.getHand().getHand(), false));
		}
	}

	/**
	 * @param player  player being compared
	 *           
	 * @return if the player won or not
	 */
	public boolean checkIfPlayerBeatDealer(Player player) {
		int dealerScore = dealer.getHand().getValueOfHand() > 21 ? dealer.getHand().getSoftValue()
				: dealer.getHand().getValueOfHand();
		int playerScore = player.getHand().getValueOfHand() > 21 ? player.getHand().getSoftValue()
				: player.getHand().getValueOfHand();
		return playerScore > dealerScore;
	}

	public List<Player> getPalayers() {
		return palayers;
	}

	public Dealer getDealer() {
		return dealer;
	}

	public DealerShoe getShoe() {
		return shoe;
	}

}
