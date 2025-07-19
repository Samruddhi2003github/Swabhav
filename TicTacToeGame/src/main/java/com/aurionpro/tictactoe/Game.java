package com.aurionpro.tictactoe;

import java.util.Scanner;

public class Game {
    Board board;
    private String currentPlayer;

    public Game() {
        board = new Board();
        currentPlayer = "X";
    }

    public void start() {
        Scanner scanner = new Scanner(System.in);

        while (true) {
            printBoard();

            System.out.println("Player " + currentPlayer + ", enter row and column (1-3):");

            System.out.print("Row: ");
            int row = scanner.nextInt() - 1;

            System.out.print("Col: ");
            int col = scanner.nextInt() - 1;

            if (row < 0 || row >= 3 || col < 0 || col >= 3) {
                System.out.println("Invalid position! Try again.");
                continue;
            }

            try {
                board.placeMark(row, col, currentPlayer);
            } catch (Exception e) {
                System.out.println("Error: " + e.getMessage());
                continue;
            }

            String winner = board.checkWinner();
            if (winner != null) {
                printBoard();
                System.out.println("Player " + winner + " wins!");
                break;
            }

            if (board.isFull()) {
                printBoard();
                System.out.println("It's a draw!");
                break;
            }

            switchPlayer();
        }

    }

    public void switchPlayer() {
        currentPlayer = currentPlayer.equals("X") ? "O" : "X";
    }

    public String getCurrentPlayer() {
        return currentPlayer;
    }

    public void printBoard() {
        System.out.println();
        for (int row = 0; row < 3; row++) {
            for (int col = 0; col < 3; col++) {
                String val = board.getCell(row, col).getValue();
                System.out.print(" " + (val != null ? val : "_") + " ");
                if (col < 2) System.out.print("|");
            }
            System.out.println();
            if (row < 2) System.out.println("-----------");
        }
        System.out.println();
    }
}
