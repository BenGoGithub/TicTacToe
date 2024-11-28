package model.etat;

import controller.GameController;
import model.player.Player;

public class GameOverState implements GameState {
    private final Player winner;

    public GameOverState(Player winner) {
        this.winner = winner;
    }

    @Override
    public void makeMove(GameController controller) {
        if (winner != null) {
            controller.getView().displayWinner(winner);
        } else {
            controller.getView().displayDraw();
        }
    }

    @Override
    public boolean checkWin(GameController controller) {
        return winner != null;
    }

    @Override
    public void nextTurn(GameController controller) {
        controller.getView().displayGameOver();
    }
}