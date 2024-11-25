package ui;

import java.util.Scanner;

public class InteractionUtilisateur {
    public final Scanner scanner;

    public InteractionUtilisateur() {
        this.scanner = new Scanner(System.in);
    }

    public int[] demanderCoordonnees(String symboleJoueur) {
        System.out.println("Joueur " + symboleJoueur + ", entrez les coordonnées (ligne colonne) : ");
        int ligne = scanner.nextInt() - 1;
        int colonne = scanner.nextInt() - 1;
        return new int[]{ligne, colonne};
    }

    public boolean demanderRejouer() {
        System.out.println("Voulez-vous rejouer ? (o/n)");
        return scanner.next().toLowerCase().startsWith("o");
    }

    public int demanderChoixJeu() {
        System.out.println("Choisissez un jeu :");
        System.out.println("1. Tic-Tac-Toe");
        System.out.println("2. Puissance 4");
        return scanner.nextInt();
    }

    public int demanderTypeJoueur(int numeroJoueur) {
        System.out.println("Choisissez le type de joueur " + numeroJoueur + " (1: Humain, 2: IA) : ");
        return scanner.nextInt();
    }

    public void fermer() {
        scanner.close();
    }
}