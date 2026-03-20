package com.tictactoe.strategy;

import com.tictactoe.model.Board;
import com.tictactoe.model.Move;

import java.util.Random;

public class AIMoveStrategy implements MoveStrategy {

    private Random random = new Random();

    @Override
    public Move getMove(Board board) {
        int row = random.nextInt(3);
        int col = random.nextInt(3);
        return new Move(row, col);
    }
}
