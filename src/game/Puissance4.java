package game;

import model.Plateau;
import model.State;

public class Puissance4 extends Plateau {
    private static final int LIGNES = 6;
    private static final int COLONNES = 7;
    private static final int ALIGNEMENT = 4;

    public Puissance4() {
        super(LIGNES, COLONNES);
    }

    @Override
    public boolean placerJeton(int colonne, State joueur) {
        for (int ligne = LIGNES - 1; ligne >= 0; ligne--) {
            if (grille[ligne][colonne] == State.EMPTY) {
                grille[ligne][colonne] = joueur;
                return true;
            }
        }
        return false;
    }

    @Override
    public boolean estVictoire(State joueur) {
        // Vérification horizontale, verticale et diagonale
        for (int ligne = 0; ligne < LIGNES; ligne++) {
            for (int colonne = 0; colonne < COLONNES; colonne++) {
                if (verifierAlignement(ligne, colonne, 0, 1, joueur) ||
                        verifierAlignement(ligne, colonne, 1, 0, joueur) ||
                        verifierAlignement(ligne, colonne, 1, 1, joueur) ||
                        verifierAlignement(ligne, colonne, -1, 1, joueur)) {
                    return true;
                }
            }
        }
        return false;
    }

    private boolean verifierAlignement(int ligneDepart, int colonneDepart, int dirLigne, int dirColonne, State joueur) {
        for (int i = 0; i < ALIGNEMENT; i++) {
            int ligne = ligneDepart + i * dirLigne;
            int colonne = colonneDepart + i * dirColonne;
            if (ligne < 0 || ligne >= LIGNES || colonne < 0 || colonne >= COLONNES ||
                    grille[ligne][colonne] != joueur) {
                return false;
            }
        }
        return true;
    }

    @Override
    public boolean estPlein() {
        for (int colonne = 0; colonne < COLONNES; colonne++) {
            if (grille[0][colonne] == State.EMPTY) {
                return false;
            }
        }
        return true;
    }

    @Override
    public State getEtat(int ligne, int colonne) {
        return grille[ligne][colonne];
    }
}