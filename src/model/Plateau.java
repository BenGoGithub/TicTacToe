package model;



public abstract class Plateau {
    protected State[][] grille;
    protected int lignes;
    protected int colonnes;

    public Plateau(int lignes, int colonnes) {
        this.lignes = lignes;
        this.colonnes = colonnes;
        this.grille = new State[lignes][colonnes];
        initialiserGrille();
    }

    protected void initialiserGrille() {
        for (int i = 0; i < lignes; i++) {
            for (int j = 0; j < colonnes; j++) {
                grille[i][j] = State.EMPTY;
            }
        }
    }

    public abstract boolean placerJeton(int colonne, State joueur);
    public abstract boolean estVictoire(State joueur);
    public abstract boolean estPlein();
    public abstract State getEtat(int ligne, int colonne);

    public int getLignes() {
        return lignes;
    }

    public int getColonnes() {
        return colonnes;
    }

    public boolean estColonneValide(int colonne) {
        return colonne >= 0 && colonne < colonnes && grille[0][colonne] == State.EMPTY;
    }
}