package model;

public class GameModel {
    private final Plateau plateau;
    private final Player[] joueurs;
    private int joueurActuel;

    public GameModel(Player joueur1, Player joueur2) {
        this.plateau = new Plateau(3);
        this.joueurs = new Player[]{joueur1, joueur2};
        this.joueurActuel = 0; // Commence avec le premier joueur
    }

    public boolean placerJeton(int x, int y) {
        return plateau.placerJeton(x, y, joueurs[joueurActuel].getSymbole());
    }

    public void changerJoueur() {
        joueurActuel = 1 - joueurActuel;
    }

    public Player getJoueurActuel() {
        return joueurs[joueurActuel];
    }

    public boolean estPartieTerminee() {
        return estVictoire() || estMatchNul();
    }

    public boolean estVictoire() {
        return plateau.estVictoire(joueurs[0].getSymbole()) || plateau.estVictoire(joueurs[1].getSymbole());
    }

    public boolean estMatchNul() {
        return plateau.estPlein();
    }

    public Player getGagnant() {
        if (plateau.estVictoire(joueurs[0].getSymbole())) return joueurs[0];
        if (plateau.estVictoire(joueurs[1].getSymbole())) return joueurs[1];
        return null;
    }

    public Plateau getPlateau() {
        return plateau;
    }
}

