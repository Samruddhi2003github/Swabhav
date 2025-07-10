package com.aurionpro.practice;

import java.util.Scanner;

public class PigGame {
	private static final int TARGET_SCORE = 20;

	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		Score totalScore = new Score();
		int turns = 0;

		while (!totalScore.hasReachedLimit(TARGET_SCORE)) {
			System.out.println("\nTurn " + (turns + 1));
			PlayerTurn turn = new PlayerTurn(scanner);
			int turnPoints = turn.play();
			totalScore.add(turnPoints);
			System.out.println("Total Score: " + totalScore.getValue());
			turns++;
		}

		System.out.println("You finished in " + turns + " turns. Game over!");
		scanner.close();
	}
}
