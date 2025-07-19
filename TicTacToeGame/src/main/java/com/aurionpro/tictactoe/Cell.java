package com.aurionpro.tictactoe;

public class Cell {
    private String value;

    public Cell() {
        value = null;
    }

    public boolean isEmpty() {
        return value == null;
    }

    public void mark(String symbol) {
        if (!isEmpty()) {
            throw new IllegalStateException("Cell already marked");
        }

        if (!symbol.equals("X") && !symbol.equals("O")) {
            throw new IllegalArgumentException("Only X or O allowed");
        }

        value = symbol;
    }

    public String getValue() {
        return value;
    }
}
