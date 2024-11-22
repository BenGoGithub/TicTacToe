package ui;

import model.Plateau;


public class View {
    public void afficherPlateau(Plateau plateau) {
        for (int i = 0; i < plateau.getLignes(); i++) {
            for (int j = 0; j < plateau.getColonnes(); j++) {
                System.out.print("|" + plateau.getEtat(i, j).getValue());
            }
            System.out.println("|");
        }
        System.out.println("-".repeat(plateau.getColonnes() * 2 + 1));
    }

    public void afficherTourJoueur(String joueur) {
        System.out.println("C'est au tour du joueur " + joueur);
    }

    public void afficherCoupInvalide() {
        System.out.println("Coup invalide. Réessayez.");
    }

    public void afficherVictoire(String joueur) {
        System.out.println("Le joueur " + joueur + " a gagné !");
    }

    public void afficherMatchNul() {
        System.out.println("Match nul !");
    }
}
