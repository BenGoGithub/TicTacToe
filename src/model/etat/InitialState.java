package model.etat;

import controller.GameController;

public class InitialState implements GameState {
    @Override
    public void makeMove(GameController controller) {
        controller.getView().displayGameStart(controller.getCurrentPlayer());
        controller.changeState(new Player1TurnState());
    }

    @Override
    public boolean checkWin(GameController controller) {
        return false;
    }

    @Override
    public void nextTurn(GameController controller) {
        controller.changeState(new Player1TurnState());
    }
}