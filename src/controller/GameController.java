package controller;


import model.board.Board;
import model.etat.*;
import model.player.Player;
import view.GameView;
import view.UserInputView;

public abstract class GameController {
    protected Board board;
    protected Player[] players;
    protected GameView view;
    protected UserInputView inputView;
    protected int currentPlayerIndex;
    protected GameState currentState;

    public GameController(Board board, Player[] players) {
        this.board = board;
        this.players = players;
        this.view = new GameView();
        this.inputView = new UserInputView();
        this.currentPlayerIndex = 0;
        this.currentState = new InitialState();
    }

    public void play() {
        while (!(currentState instanceof GameOverState)) {
            view.displayBoard(board);
            currentState.makeMove(this);
        }
        view.displayBoard(board);
        currentState.makeMove(this);
    }

    public void switchPlayer() {
        currentPlayerIndex = 1 - currentPlayerIndex;
    }

    public void changeState(GameState newState) {
        this.currentState = newState;
    }

    public Player getCurrentPlayer() {
        return players[currentPlayerIndex];
    }

    public Board getBoard() {
        return board;
    }

    public GameView getView() {
        return this.view;
    }
}