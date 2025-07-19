package com.aurionpro.tictactoe;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;

public class GameTest {

    @Test
    public void testSwitchPlayer() {
        Game game = new Game();
        assertEquals("X", game.getCurrentPlayer());
        game.switchPlayer();
        assertEquals("O", game.getCurrentPlayer());
    }

    @Test
    public void testBoardFullDetection() {
        Game game = new Game();

        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                game.board.placeMark(i, j, "X");
            }
        }

        assertTrue(game.board.isFull());
    }
}
