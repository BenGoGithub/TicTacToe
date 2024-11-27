package model;

import java.util.Random;

public class AIPlayer implements Player {
    private final State symbole;
    private final String nom;

    public AIPlayer(State symbole, String nom) {
        this.symbole = symbole;
        this.nom = nom;
    }

    @Override
    public State getSymbole() {
        return symbole;
    }

    @Override
    public String getNom() {
        return nom;
    }
    @Override
    public int[] makeMove(Plateau plateau) {
        // Logique simple pour l'IA : choisir une case vide aléatoirement
        Random random = new Random();
        int x, y;
        do {
            x = random.nextInt(plateau.getTaille());
            y = random.nextInt(plateau.getTaille());
        } while (plateau.getEtat(x, y) != State.EMPTY);
        return new int[]{x, y};
    }
}