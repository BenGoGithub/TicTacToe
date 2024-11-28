package controller;

import model.board.ConnectFourBoard;
import model.player.Player;

public class ConnectFourController extends GameController {
    public ConnectFourController(Player[] players) {
        super(new ConnectFourBoard(), players);
    }
}