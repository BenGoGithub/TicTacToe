import Player.ArtificialPlayer;
import Player.HumanPlayer;
import Player.Player;

import java.util.Scanner;

public static void main(String[] args) {
    Scanner scanner = new Scanner(System.in);
    int choice;

    do {
        displayMenu();
        choice = getUserChoice(scanner);

        switch (choice) {
            case 1:
                playGame(new HumanPlayer("X"), new HumanPlayer("O"));
                break;
            case 2:
                playGame(new HumanPlayer("X"), new ArtificialPlayer("O"));
                break;
            case 3:
                playGame(new ArtificialPlayer("X"), new ArtificialPlayer("O"));
                break;
            case 4:
                System.out.println("Merci d'avoir joué ! Au revoir.");
                break;
            default:
                System.out.println("Choix invalide. Veuillez réessayer.");
        }
    } while (choice != 4);

    scanner.close();
}

private static void displayMenu() {
    System.out.println("\n=== Menu Tic-Tac-Toe ===");
    System.out.println("1. Jouer Humain vs Humain");
    System.out.println("2. Jouer Humain vs IA");
    System.out.println("3. Regarder IA vs IA");
    System.out.println("4. Quitter");
    System.out.print("Entrez votre choix : ");
}

private static int getUserChoice(Scanner scanner) {
    while (!scanner.hasNextInt()) {
        System.out.println("Veuillez entrer un nombre valide.");
        scanner.next();
    }
    return scanner.nextInt();
}

private static void playGame(Player player1, Player player2) {
    TicTacToe game = new TicTacToe(player1, player2);
    game.play();

    System.out.println("\nVoulez-vous rejouer ? (o/n)");
    Scanner scanner = new Scanner(System.in);
    String replay = scanner.nextLine().toLowerCase();
    if (replay.equals("o")) {
        playGame(player1, player2);
    }
}