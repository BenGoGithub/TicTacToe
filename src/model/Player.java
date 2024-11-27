package model;

public interface Player {
    State getSymbole();
    String getNom();
    int[] makeMove(Plateau plateau);
}