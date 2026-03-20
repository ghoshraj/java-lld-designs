package com.tictactoe.strategy;

import com.tictactoe.model.Board;
import com.tictactoe.model.Move;

import java.util.Scanner;

public class HumanMoveStrategy implements MoveStrategy{

    private Scanner scanner = new Scanner(System.in);

    @Override
    public Move getMove(Board board) {
        System.out.print("Enter row: ");
        int row = scanner.nextInt();

        System.out.print("Enter col: ");
        int col = scanner.nextInt();

        return new Move(row, col);
    }
}
