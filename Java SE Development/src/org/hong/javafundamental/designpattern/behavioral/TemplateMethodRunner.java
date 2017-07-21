package org.hong.javafundamental.designpattern.behavioral;

public class TemplateMethodRunner {

	public static void main(String[] args) {
		
		Game monopoly = new Monopoly();
		Game chess = new Chess();
		
		chess.playOneGame(2);
		monopoly.playOneGame(4);
	}
}
