package model.etat;

import controller.GameController;

public interface GameState {
    void makeMove(GameController controller);
    boolean checkWin(GameController controller);
    void nextTurn(GameController controller);
}