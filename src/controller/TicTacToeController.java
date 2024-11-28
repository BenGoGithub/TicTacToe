package controller;

import model.board.TicTacToeBoard;
import model.player.Player;

public class TicTacToeController extends GameController {
    public TicTacToeController(Player[] players) {
        super(new TicTacToeBoard(), players);
    }
}