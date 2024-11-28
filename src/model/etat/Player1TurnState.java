package model.etat;

import controller.GameController;


public class Player1TurnState extends PlayerTurnState {
    @Override
    public void nextTurn(GameController controller) {
        controller.switchPlayer();
        controller.changeState(new Player2TurnState());
    }
}