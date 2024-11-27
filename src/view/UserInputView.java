package view;

import java.util.Scanner;

public class UserInputView {
    private final Scanner scanner = new Scanner(System.in);

    public int[] demanderCoordonnees() {
        System.out.println("Entrez les coordonnées de 1 à 3n (Ligne Colonne): ");
        int x = scanner.nextInt() - 1;
        int y = scanner.nextInt() - 1;
        return new int[]{x, y};
    }

    public boolean demanderRejouer() {
        System.out.println("Voulez-vous rejouer ? (O/N)");
        String reponse = scanner.next();
        return reponse.equalsIgnoreCase("O");
    }
    public boolean choisirJoueurHumain(int numeroJoueur) {
        System.out.println("Le joueur " + numeroJoueur + " est-il humain ? (O/N)");
        String reponse = scanner.next();
        return reponse.equalsIgnoreCase("O");
    }
}