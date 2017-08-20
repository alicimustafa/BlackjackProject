package com.mustafa.blakjack;

import java.util.ArrayList;
import java.util.List;
import java.util.MissingFormatArgumentException;
import java.util.Scanner;

public class BlackjackGameApp {
	
	List<Player> palayers;

	public static void main(String[] args) {
		Scanner keyboard = new Scanner(System.in);
		BlackjackGameApp game = new BlackjackGameApp();
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
		game.gameStart(input , keyboard);

	}
	
	public BlackjackGameApp() {
		palayers = new ArrayList<>();
		
	}
	
	public void gameStart(int players, Scanner keyboard) {
		
	}
	
	
}
