package player;

import model.Plateau;
import model.Player;
import model.State;

import java.util.Random;

public class ArtificialPlayer implements Player {
    private final State state;
    private final Random random;

    public ArtificialPlayer(State state) {
        this.state = state;
        this.random = new Random();
    }

    @Override
    public State getState() {
        return state;
    }

    @Override
    public int[] makeMove(Plateau plateau) {
        int colonne;
        do {
            colonne = random.nextInt(plateau.getColonnes());
        } while (!plateau.estColonneValide(colonne));
        return new int[]{0, colonne}; // La ligne est déterminée par le plateau
    }
}