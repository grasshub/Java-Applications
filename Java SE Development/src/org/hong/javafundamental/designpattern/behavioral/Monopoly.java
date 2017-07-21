package org.hong.javafundamental.designpattern.behavioral;

public class Monopoly extends Game {

	public void initializeGame() {
		System.out.println("Initialize monoploy game");
	}
	
	public void play(int player) {
		System.out.printf("The %d player is playing monopoly%n", player + 1);
	}
	
	public boolean endOfGame() {
		System.out.println("Does the game over for monopoly?");
		return false;
	}
	
	public void printWinner() {
		System.out.printf("The winner of the monopoly game is: %d player%n", playersCount);
	}
}
