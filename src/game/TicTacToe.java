package game;

import model.Plateau;
import model.State;


public class TicTacToe extends Plateau {
    private static final int TAILLE = 3;

    public TicTacToe() {
        super(TAILLE, TAILLE);
    }

    @Override
    public boolean placerJeton(int colonne, State joueur) {
        int ligne = TAILLE - 1;
        while (ligne >= 0 && grille[ligne][colonne] != State.EMPTY) {
            ligne--;
        }
        if (ligne >= 0) {
            grille[ligne][colonne] = joueur;
            return true;
        }
        return false;
    }

    @Override
    public boolean estVictoire(State joueur) {
        // Vérification des lignes, colonnes et diagonales
        for (int i = 0; i < TAILLE; i++) {
            if ((grille[i][0] == joueur && grille[i][1] == joueur && grille[i][2] == joueur) ||
                    (grille[0][i] == joueur && grille[1][i] == joueur && grille[2][i] == joueur)) {
                return true;
            }
        }
        return (grille[0][0] == joueur && grille[1][1] == joueur && grille[2][2] == joueur) ||
                (grille[0][2] == joueur && grille[1][1] == joueur && grille[2][0] == joueur);
    }

    @Override
    public boolean estPlein() {
        for (int i = 0; i < TAILLE; i++) {
            for (int j = 0; j < TAILLE; j++) {
                if (grille[i][j] == State.EMPTY) {
                    return false;
                }
            }
        }
        return true;
    }

    @Override
    public State getEtat(int ligne, int colonne) {
        return grille[ligne][colonne];
    }
}