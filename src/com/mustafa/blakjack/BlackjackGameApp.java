package com.mustafa.blakjack;

import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.List;
import java.util.Scanner;

/**
 * @author mustafaalici this the main class that runs whole game
 */
public class BlackjackGameApp {

	List<Player> players;
	Dealer dealer;
	DealerShoe shoe;

	public static void main(String[] args) {
		Scanner keyboard = new Scanner(System.in);
		BlackjackGameApp game = new BlackjackGameApp(4);
		System.out.println("Welcome to Black Jack");
		//game.gameStart(keyboard);

		
	}

	/**
	 * @param numDecks
	 *            number of decks to be generated this is the constructor for the
	 *            main app it fill the dealer shoe with card and suffles it
	 */
	public BlackjackGameApp(int numDecks) {
		players = new ArrayList<>();
		dealer = new Dealer();
		List<Card> setDecks = DeckGenerator.getDeck(Rank.values(), Suit.values(), numDecks);
		shoe = new DealerShoe(setDecks);
		shoe.shuffleDeck();
		shoe.shuffleDeck();
	}

	/**
	 * @param playerNum
	 *            number players vs the dealer
	 * @param keyboard
	 *            this stars the whole thing generating player
	 */
	public void gameStart(int playerNum, Scanner keyboard) {
		int[] playerScoreArr = new int[playerNum];
		for (int i = 0; i < playerNum; i++) {
			System.out.println("Enter player" + (i + 1));
			System.out.print("Name: ");
			String name = keyboard.next();
			this.players.add(new Player(name));
		}
		for (int i = 0; i < 2; i++) {
			for (Player player : players) {
				player.takeCard(shoe.drawCard());
			}
			dealer.takeCard(shoe.drawCard());
		}
		drawBoard();
		for (int i = 0; i < players.size(); i++) {
			System.out.println(players.get(i).getName() + " this is your turn");
			playerScoreArr[i] = runPlayerTurn(players.get(i));
			String message = playerScoreArr[i] == 1 ? "You got Blackjack"
					: playerScoreArr[i] == -1 ? "Sorry you Busted" : "You Stayed";
			System.out.println(message);
		}
		int dealerResult = runPlayerTurn(dealer);

		for (int i = 0; i < players.size(); i++) {
			switch (playerScoreArr[i]) {
			case 1:
				break;
			case 0:
				break;
			case -1:

				break;
			}
			// switch (dealerResult) {
			// case 1:
			// if (playerScoreArr[i] == 1) {
			// System.out.println("Player " + players.get(i).getName() + " you tied dealer
			// with blackjac ");
			// } else {
			// System.out.println("Player " + players.get(i).getName() + " Sorry dealer beat
			// you with blackjack ");
			// }
			// break;
			// case 0:
			// if (playerScoreArr[i] == -1) {
			// System.out.println("Player " + players.get(i).getName() + " Sorry you busted
			// ");
			// } else if (checkIfPlayerBeatDealer(players.get(i))) {
			// System.out.println("Player " + players.get(i).getName() + " you beat the
			// dealer");
			// } else {
			// System.out.println("Player " + players.get(i).getName() + " the dealer beat
			// you");
			// }
			// break;
			// case -1:
			// if (playerScoreArr[i] == -1) {
			// System.out.println("Player " + players.get(i).getName() + " Sorry you busted
			// ");
			// } else {
			// System.out.println("Player " + players.get(i).getName() + " won dealer busted
			// you win");
			// }
			// break;
			// }
		}
	}
	public void displayIntro() {
		System.out.println("**************************************");
		System.out.println("\u2664\u2667\u2661\u2662  Welcome to Blackjack  \u2664\u2667\u2661\u2662");
		System.out.println("**************************************");
	}

	public List<Player> enterPlayerInfo(int numberPlayers, Scanner keyboard) {
		List<Player> playerList = new ArrayList<>();
		System.out.println("Enter player name and starting Cash");
		for(int i = 0; i < numberPlayers; i++) {
			System.out.print("Enter player" + i + " name");
			String name = keyboard.next();
			System.out.print("Enter player" + i + " cash");
			double cash = keyboard.nextDouble();
			playerList.add(new Player(name, cash));
		}
		return playerList;
	}
	
	public int askHowManyPlayers(Scanner keyboard) {
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
		
		return input;
	}
	
	public int askDeckSizeOfShoe(Scanner keyboard) {
		int input = 0;
		do {
			try {
				System.out.println("How Many Decks in Dealer Shoe (1-8)");
				input = keyboard.nextInt();
			} catch (InputMismatchException e) {
				System.out.println("you must enter a number");
				keyboard.nextLine();
			}

		} while (input < 1 || input > 8);
		
		return input;
	}

	/**
	 * @param player
	 *            player's turn being run or the dealer
	 * @return returns -1 if players bust 1 if player hits blackjack 0 if neither
	 *         first checks if player has blackjack if not gets player move checks
	 *         for bust ask again till player stays.
	 */
	public int runPlayerTurn(Actor player) {
		CardDrawer draw = new CardDrawer();
		int playerResponse = 1;
		int playerCard1 = player.getHand().getHand().get(0).getRank().getValue()[0];
		int playerCard2 = player.getHand().getHand().get(1).getRank().getValue()[0];

		if (playerCard1 + playerCard2 == 21) {
			return 1;
		}

		do {
			System.out.println(draw.drawFace(player.getHand().getHand(), false));
			playerResponse = player.makeMove();
			if (playerResponse == 1) {
				player.takeCard(shoe.drawCard());
				if (player.getHand().checkIfPlayerBust()) {
					System.out.println(draw.drawFace(player.getHand().getHand(), false));
					return -1;
				}
			}

		} while (playerResponse == 1);
		return 0;

	}
	
	/**
	 * this draws the ascii art for all of the player and dealer representing cards
	 * 
	 */
	public void drawBoard() {
		CardDrawer draw = new CardDrawer();
		System.out.println("Dealer");
		System.out.println(draw.drawFace(dealer.getHand().getHand(), true));
		for (Player player : players) {
			System.out.println("Player: " + player.getName());
			System.out.println(draw.drawFace(player.getHand().getHand(), false));
		}
	}

	/**
	 * @param player
	 *            player being compared
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
		return players;
	}

	public Dealer getDealer() {
		return dealer;
	}

	public DealerShoe getShoe() {
		return shoe;
	}

}
