package com.aurionpro.tictactoe;

public class Board {
    private Cell[][] grid;

    public Board() {
        grid = new Cell[3][3];
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                grid[i][j] = new Cell();
            }
        }
    }

    public Cell getCell(int row, int col) {
        return grid[row][col];
    }

    public void placeMark(int row, int col, String symbol) {
        grid[row][col].mark(symbol);
    }

    public String checkWinner() {
        //rows
        for (int i = 0; i < 3; i++) {
            if (!grid[i][0].isEmpty() &&
                grid[i][0].getValue().equals(grid[i][1].getValue()) &&
                grid[i][1].getValue().equals(grid[i][2].getValue())) {
                return grid[i][0].getValue();
            }
        }

        //columns
        for (int i = 0; i < 3; i++) {
            if (!grid[0][i].isEmpty() &&
                grid[0][i].getValue().equals(grid[1][i].getValue()) &&
                grid[1][i].getValue().equals(grid[2][i].getValue())) {
                return grid[0][i].getValue();
            }
        }

        //Diagonals
        if (!grid[0][0].isEmpty() &&
            grid[0][0].getValue().equals(grid[1][1].getValue()) &&
            grid[1][1].getValue().equals(grid[2][2].getValue())) {
            return grid[0][0].getValue();
        }

        if (!grid[0][2].isEmpty() &&
            grid[0][2].getValue().equals(grid[1][1].getValue()) &&
            grid[1][1].getValue().equals(grid[2][0].getValue())) {
            return grid[0][2].getValue();
        }

        return null;
    }

    public boolean isFull() {
        for (int row = 0; row < 3; row++) {
            for (int col = 0; col < 3; col++) {
                if (grid[row][col].isEmpty()) {
                    return false;
                }
            }
        }
        return true;
    }
}
