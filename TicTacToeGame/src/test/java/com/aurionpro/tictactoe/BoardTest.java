package com.aurionpro.tictactoe;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;

public class BoardTest {

    @Test
    public void testAllCellsEmptyWhenBoardIsCreated() {
        Board board = new Board();
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                assertTrue(board.getCell(i, j).isEmpty());
            }
        }
    }

    @Test
    public void testCanPlaceMarkOnBoard() {
        Board board = new Board();
        board.placeMark(1, 1, "X");
        assertEquals("X", board.getCell(1, 1).getValue());
    }

    @Test
    public void testCannotPlaceMarkTwiceOnSameCell() {
        Board board = new Board();
        board.placeMark(0, 0, "O");

        Exception e = assertThrows(IllegalStateException.class, () -> {
            board.placeMark(0, 0, "X");
        });

        assertEquals("Cell already marked", e.getMessage());
    }

    @Test
    public void testCheckWinnerInRow() {
        Board board = new Board();
        board.placeMark(0, 0, "X");
        board.placeMark(0, 1, "X");
        board.placeMark(0, 2, "X");

        assertEquals("X", board.checkWinner());
    }

    @Test
    public void testCheckWinnerInColumn() {
        Board board = new Board();
        board.placeMark(0, 1, "O");
        board.placeMark(1, 1, "O");
        board.placeMark(2, 1, "O");

        assertEquals("O", board.checkWinner());
    }

    @Test
    public void testCheckWinnerInDiagonal() {
        Board board = new Board();
        board.placeMark(0, 0, "X");
        board.placeMark(1, 1, "X");
        board.placeMark(2, 2, "X");

        assertEquals("X", board.checkWinner());
    }

    @Test
    public void testNoWinnerYet() {
        Board board = new Board();
        board.placeMark(0, 0, "X");
        board.placeMark(0, 1, "O");
        board.placeMark(0, 2, "X");

        assertNull(board.checkWinner());
    }
}
