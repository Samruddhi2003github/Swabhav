package com.aurionpro.tictactoe;

import java.util.Scanner;

public class TicTacToeTest {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String response;

        do {
            GameFacade facade = new GameFacade();
            facade.playGame();

            System.out.println("Do you want to play again? (y/n): ");
            response = sc.nextLine().trim();

            if (response.equalsIgnoreCase("y")) {
                facade.resetGame();
            }

        } while (response.equalsIgnoreCase("y"));

        sc.close();
        System.out.println("Thanks for playing!");
    }
}
