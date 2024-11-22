package model;

public interface Player {
    State getState();
    int[] makeMove(Plateau plateau);
}