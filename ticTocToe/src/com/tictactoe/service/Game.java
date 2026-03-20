package com.tictactoe.service;

import com.tictactoe.model.Board;
import com.tictactoe.model.Move;
import com.tictactoe.model.Player;

public class Game {

    private Board board;
    private Player player1;
    private Player player2;
    private Player currentPlayer;
    private int moveCount = 0;

    public Game(Player p1, Player p2) {
        this.board = new Board();
        this.player1 = p1;
        this.player2 = p2;
        this.currentPlayer = p1;
    }

    public void startGame() {
        while (true) {
            System.out.println(currentPlayer.getName() + "'s turn");

            Move move = currentPlayer.getMove(board);

            if (!board.isValidMove(move)) {
                System.out.println("Invalid move! Try again.");
                continue;
            }

            boolean isWinner = board.makeMove(move, currentPlayer);
            moveCount++;

            if (isWinner) {
                System.out.println(currentPlayer.getName() + " wins!");
                break;
            }

            if (moveCount == 9) {
                System.out.println("Game Draw!");
                break;
            }

            switchTurn();
        }
    }

    private void switchTurn() {
        currentPlayer = (currentPlayer == player1) ? player2 : player1;
    }
}
