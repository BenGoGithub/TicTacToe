package model;

import model.etat.State;

public class Cell {
    private final int x;
    private final int y;
    private State state;

    public Cell(int x, int y) {
        this.x = x;
        this.y = y;
        this.state = State.EMPTY;
    }

    public State getState() { return state; }
    public void setState(State state) { this.state = state; }
    public boolean isEmpty() { return state == State.EMPTY; }
}