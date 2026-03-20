package com.tictactoe.strategy;

import com.tictactoe.model.Board;
import com.tictactoe.model.Move;

public interface MoveStrategy {

    Move getMove(Board board);
}
