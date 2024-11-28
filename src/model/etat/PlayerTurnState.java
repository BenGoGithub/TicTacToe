package model.etat;

import controller.GameController;
import model.Move;
import model.player.Player;

public abstract class PlayerTurnState implements GameState {
    @Override
    public void makeMove(GameController controller) {
        Player currentPlayer = controller.getCurrentPlayer();
        Move move = currentPlayer.makeMove(controller.getBoard());

        if (controller.getBoard().placeToken(move.getX(), move.getY(), currentPlayer.getSymbol())) {
            if (checkWin(controller)) {
                controller.changeState(new GameOverState(currentPlayer));
            } else if (controller.getBoard().isFull()) {
                controller.changeState(new GameOverState(null));
            } else {
                nextTurn(controller);
            }
        } else {
            System.out.println("Coup invalide ! Réessayez.");
        }
    }

    @Override
    public boolean checkWin(GameController controller) {
        return controller.getBoard().checkWin(controller.getCurrentPlayer().getSymbol());
    }
}