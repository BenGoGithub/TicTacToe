package view;

import model.Plateau;
import model.State;

public class GameView {
    public void afficherPlateau(Plateau plateau) {
        System.out.println("-------------");
        for (int i = 0; i < plateau.getTaille(); i++) {
            System.out.print("| ");
            for (int j = 0; j < plateau.getTaille(); j++) {
                System.out.print(plateau.getEtat(i, j) == State.EMPTY ? " " : plateau.getEtat(i, j));
                System.out.print(" | ");
            }
            System.out.println("\n-------------");
        }
    }

    public void afficherTourJoueur(String joueur) {
        System.out.println("C'est le tour de " + joueur);
    }

    public void afficherVictoire(String joueur) {
        System.out.println(joueur + " a gagné !");
    }

    public void afficherMatchNul() {
        System.out.println("Match nul !");
    }

    public void afficherCoupInvalide() {
        System.out.println("Coup invalide. Essayez encore.");
    }
}