package model;

public class Plateau {
    private final State[][] grille;
    private final int taille;

    public Plateau(int taille) {
        this.taille = taille;
        this.grille = new State[taille][taille];
        initialiserGrille();
    }

    private void initialiserGrille() {
        for (int i = 0; i < taille; i++) {
            for (int j = 0; j < taille; j++) {
                grille[i][j] = State.EMPTY;
            }
        }
    }

    public boolean placerJeton(int x, int y, State state) {
        if (x >= 0 && x < taille && y >= 0 && y < taille && grille[x][y] == State.EMPTY) {
            grille[x][y] = state;
            return true;
        }
        return false;
    }

    public boolean estVictoire(State state) {
        // Vérifier les lignes et les colonnes
        for (int i = 0; i < taille; i++) {
            if (tousIdentiques(grille[i], state) || tousIdentiques(getColonne(i), state)) {
                return true;
            }
        }
        // Vérifier les diagonales
        return tousIdentiques(getDiagonalePrincipale(), state) || tousIdentiques(getDiagonaleSecondaire(), state);
    }

    private boolean tousIdentiques(State[] ligne, State state) {
        for (State s : ligne) {
            if (s != state) return false;
        }
        return true;
    }

    private State[] getColonne(int col) {
        State[] colonne = new State[taille];
        for (int i = 0; i < taille; i++) {
            colonne[i] = grille[i][col];
        }
        return colonne;
    }

    private State[] getDiagonalePrincipale() {
        State[] diagonale = new State[taille];
        for (int i = 0; i < taille; i++) {
            diagonale[i] = grille[i][i];
        }
        return diagonale;
    }

    private State[] getDiagonaleSecondaire() {
        State[] diagonale = new State[taille];
        for (int i = 0; i < taille; i++) {
            diagonale[i] = grille[i][taille - 1 - i];
        }
        return diagonale;
    }

    public boolean estPlein() {
        for (State[] ligne : grille) {
            for (State cell : ligne) {
                if (cell == State.EMPTY) return false;
            }
        }
        return true;
    }

    public State getEtat(int x, int y) {
        return grille[x][y];
    }

    public int getTaille() {
        return taille;
    }
}