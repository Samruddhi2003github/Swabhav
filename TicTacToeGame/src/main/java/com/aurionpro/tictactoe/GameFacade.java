package com.aurionpro.tictactoe;

public class GameFacade {
    private Game game;

    public GameFacade() {
        game = new Game();
    }

    public void playGame() {
        game.start();
    }

    public void resetGame() {
        game = new Game();
    }

    public String getCurrentPlayer() {
        return game.getCurrentPlayer();
    }
}
