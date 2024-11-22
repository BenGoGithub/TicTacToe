package ui;

import model.State;

public class View {
    public void afficherTitre() {
        System.out.println("=== TIC-TAC-TOE ===");
        System.out.println("Joueur 1: X | Joueur 2: O");
        System.out.println("Entrez les coordonnées (1-3) pour jouer");
    }

    public void afficherPlateau(State[][] plateau) {
        System.out.println("-------------------");
        for (State[] ligne : plateau) {
            System.out.print("| ");
            for (State cellule : ligne) {
                System.out.print(cellule.getValue() + " | ");
            }
            System.out.println("\n-------------------");
        }
    }

    public void afficherTourJoueur(String joueur) {
        System.out.println("C'est au tour du joueur " + joueur);
    }

    public void afficherCoupInvalide() {
        System.out.println("Mouvement invalide. Réessayez.");
    }

    public void afficherVictoire(String joueur) {
        System.out.println("Le joueur " + joueur + " a gagné !");
    }

    public void afficherMatchNul() {
        System.out.println("Match nul !");
    }
}