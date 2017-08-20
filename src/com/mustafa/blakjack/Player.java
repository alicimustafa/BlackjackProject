package com.mustafa.blakjack;

import java.util.InputMismatchException;
import java.util.Scanner;

public class Player implements Actor {
	
	private GameHand hand;
	String name;

	public Player() {
		super();
		hand = new GameHand();
	}

	@Override
	public int makeMove() {
		Scanner keyboard = new Scanner(System.in);
		int input = 0;
		System.out.println("Make your move (1)Hit or (2)Stay ");
		do {
			try {
				input = keyboard.nextInt();
			} catch (InputMismatchException e) {
				
			}
		} while (input < 1 || input > 2);
		keyboard.close();
		return input;
	}

	@Override
	public void takeCard(Card card) {
		hand.addCard(card);
	}

	public GameHand getHand() {
		return hand;
	}
	
	
}
