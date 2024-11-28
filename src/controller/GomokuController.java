package controller;

import model.board.GomokuBoard;
import model.player.Player;

public class GomokuController extends GameController {
    public GomokuController(Player[] players) {
        super(new GomokuBoard(), players);
    }
}