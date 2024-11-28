package model.player;

import model.Move;
import model.board.Board;
import model.etat.State;

public abstract class Player {
    protected String name;
    protected State symbol;

    public Player(String name, State symbol) {
        this.name = name;
        this.symbol = symbol;
    }

    public String getName() { return name; }
    public State getSymbol() { return symbol; }

    public abstract Move makeMove(Board board);
}