package ui;

import java.util.Scanner;

public class InteractionUtilisateur {
    private final Scanner scanner;

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

    public int demanderTypeJoueur(int numeroJoueur) {
        System.out.println("Choisissez le type de joueur " + numeroJoueur + " (1: Humain, 2: IA) : ");
        return scanner.nextInt();
    }

    public void fermer() {
        scanner.close();
    }
}
