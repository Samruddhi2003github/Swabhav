package com.aurionpro.tictactoe;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

public class GameFacadeTest {

    @Test
    public void testGameReset() {
        GameFacade facade = new GameFacade();
        assertEquals("X", facade.getCurrentPlayer());
        facade.resetGame();
        assertEquals("X", facade.getCurrentPlayer());
    }
}
