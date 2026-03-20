package com.tictactoe.model;

import com.tictactoe.strategy.MoveStrategy;

public class Player {

    private String name;
    private char symbol;
    private MoveStrategy strategy;

    public Player(String name, char symbol, MoveStrategy strategy) {
        this.name = name;
        this.symbol = symbol;
        this.strategy = strategy;
    }

    public Move getMove(Board board) {
        return strategy.getMove(board);
    }

    public char getSymbol() {
        return symbol;
    }

    public String getName() {
        return name;
    }
}
