package org.hong.javafundamental.designpattern.behavioral;

public class Chess extends Game {
	
	public void initializeGame() {
		System.out.println("Initialize chess game");
	}
	
	public void play(int player) {
		System.out.printf("The %d player is playing chess%n", player + 1);
	}
	
	public boolean endOfGame() {
		System.out.println("Does the game over for chess?");
		return false;
	}
	
	public void printWinner() {
		System.out.printf("The winner of the chess game is: %d player%n", playersCount);
	}

}
