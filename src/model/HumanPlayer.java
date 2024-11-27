package model;




public class HumanPlayer implements Player {
    private final State symbole;
    private final String nom;

    public HumanPlayer(State symbole, String nom) {
        this.symbole = symbole;
        this.nom = nom;
    }

    @Override
    public State getSymbole() {
        return symbole;
    }
    @Override
    public int[] makeMove(Plateau plateau) {
        // Cette méthode sera appelée par le contrôleur
        return null; // Le contrôleur gère l'entrée pour les joueurs humains
    }

    @Override
    public String getNom() {
        return nom;
    }
}