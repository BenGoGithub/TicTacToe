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
            System.out.println(STR."Le jeu est terminé. \{winner.getName()} a gagné !");
        } else {
            System.out.println("Le jeu est terminé. C'est un match nul !");
        }
    }

    @Override
    public boolean checkWin(GameController controller) {
        return winner != null;
    }

    @Override
    public void nextTurn(GameController controller) {
        System.out.println("Le jeu est terminé !");
    }
}