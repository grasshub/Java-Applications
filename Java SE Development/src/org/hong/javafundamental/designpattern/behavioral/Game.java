package org.hong.javafundamental.designpattern.behavioral;

// Only one player can play game at a time
abstract class Game {
	
	protected int playersCount;
	
	abstract void initializeGame();
	abstract void play(int playerNumber);
	abstract boolean endOfGame();
	abstract void printWinner();
	
	public final void playOneGame(int playersCount) {
		this.playersCount = playersCount;
		initializeGame();
		int index = 0;
		
		while (!endOfGame() && index < playersCount) {
			play(index);
			index = index + 1;
		}
		printWinner();
	}

}
