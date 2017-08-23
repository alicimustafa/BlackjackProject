package com.mustafa.blakjack;

import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.List;
import java.util.Scanner;

/**
 * @author mustafaalici this the main class that runs whole game
 */
public class BlackjackGameApp {


	public static void main(String[] args) {
		Scanner keyboard = new Scanner(System.in);
		BlackjackGameApp game = new BlackjackGameApp();
		game.gameStart(keyboard);

		
	}

	
	public BlackjackGameApp() {
		
	}

	public void gameStart(Scanner keyboard) {
		this.displayIntro();
		int deckSize =  this.askDeckSizeOfShoe(keyboard);
		DealerShoe shoe = new DealerShoe(DeckGenerator.getDeck(Rank.values(), Suit.values(), deckSize));
		shoe.shuffleDeck();
		List<Player> players = this.enterPlayerInfo(this.askHowManyPlayers(keyboard), keyboard);
		String input = "";
		do {
			
			System.out.println("Do you want to play again?");
			System.out.println("(1) with the same player and shoe deck size");
			System.out.println("(2) with the same player but diferent shoe deck size");
			System.out.println("(3) with all new players and diferent shoe deck size");
			System.out.println("(Q) Quit game");
			input = keyboard.next();
			switch(input) {
			case "2":
				deckSize =  this.askDeckSizeOfShoe(keyboard);
				shoe = new DealerShoe(DeckGenerator.getDeck(Rank.values(), Suit.values(), deckSize));
				shoe.shuffleDeck();
				break;
			case "3":
				deckSize =  this.askDeckSizeOfShoe(keyboard);
				shoe = new DealerShoe(DeckGenerator.getDeck(Rank.values(), Suit.values(), deckSize));
				shoe.shuffleDeck();
				players = this.enterPlayerInfo(this.askHowManyPlayers(keyboard), keyboard);
				break;
			}
		} while(input.toLowerCase() != "Q");
		System.out.println("\n\nThank you for playing Blackjack");
		
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
	
	public void runGameTurn(List<Player> players, DealerShoe shoe, Scanner keyboard) {
		this.askPlayerBet(players, keyboard);
		for (Player player : players) {
			int i = runPlayerTurn(player);
		}
	}

	public void askPlayerBet(List<Player> players, Scanner keyboard) {
		for (Player player : players) {
			double  input = 0.00;
			do {
				try {
					System.out.println(player.getName() + " how much do you want ot bet");	
				}catch(InputMismatchException e) {
					System.out.println("You must enter a number");
				}
			}while(input > 0.00);
			player.getHand().setBet(input);
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
