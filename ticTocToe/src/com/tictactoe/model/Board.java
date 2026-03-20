package com.tictactoe.model;

public class Board {

    private int[] rows = new int[3];
    private int[] cols = new int[3];
    private int diagonal = 0;
    private int antiDiagonal = 0;

    public boolean isValidMove(Move move) {
        int r = move.getRow();
        int c = move.getCol();
        return r >= 0 && r < 3 && c >= 0 && c < 3;
    }

    public boolean makeMove(Move move, Player player) {
        int r = move.getRow();
        int c = move.getCol();

        int value = player.getSymbol() == 'X' ? 1 : -1;

        rows[r] += value;
        cols[c] += value;

        if (r == c) diagonal += value;
        if (r + c == 2) antiDiagonal += value;

        return Math.abs(rows[r]) == 3 ||
                Math.abs(cols[c]) == 3 ||
                Math.abs(diagonal) == 3 ||
                Math.abs(antiDiagonal) == 3;
    }
}
