package com.mustafa.blakjack;

import java.util.InputMismatchException;
import java.util.Scanner;

public class Player implements Actor {
	
	private GameHand hand;
	private String name;
	private double cash;

	public Player(String name) {
		super();
		hand = new GameHand();
		this.name = name;
	}
	

	public Player(String name, double cash) {
		super();
		this.name = name;
		this.cash = cash;
	}

	@Override
	public int makeMove(Scanner keyboard) {
		int input = 0;
		
		do {
			try {
				System.out.println("Make your move (1)Hit or (2)Stay ");
				input = keyboard.nextInt();
			} catch (InputMismatchException e) {
				
			}
		} while (input < 1 || input > 2);
		return input;
	}

	@Override
	public void takeCard(Card card) {
		hand.addCard(card);
	}

	public GameHand getHand() {
		return hand;
	}

	public String getName() {
		return name;
	}

	public double getCash() {
		return cash;
	}

	public void setCash(double cash) {
		this.cash = cash;
	}

	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("Player [hand=");
		builder.append(hand);
		builder.append(", name=");
		builder.append(name);
		builder.append(", cash=");
		builder.append(cash);
		builder.append("]");
		return builder.toString();
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		long temp;
		temp = Double.doubleToLongBits(cash);
		result = prime * result + (int) (temp ^ (temp >>> 32));
		result = prime * result + ((hand == null) ? 0 : hand.hashCode());
		result = prime * result + ((name == null) ? 0 : name.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Player other = (Player) obj;
		if (Double.doubleToLongBits(cash) != Double.doubleToLongBits(other.cash))
			return false;
		if (hand == null) {
			if (other.hand != null)
				return false;
		} else if (!hand.equals(other.hand))
			return false;
		if (name == null) {
			if (other.name != null)
				return false;
		} else if (!name.equals(other.name))
			return false;
		return true;
	}

}
