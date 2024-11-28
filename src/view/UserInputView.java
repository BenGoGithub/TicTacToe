package view;

import java.util.Scanner;


public class UserInputView {
    private final Scanner scanner;

    public UserInputView() {
        scanner = new Scanner(System.in);
    }

    public String getGameType() {
        System.out.println("Choisissez un jeu (TicTacToe/ConnectFour/Gomoku): ");
        return scanner.nextLine();
    }

    public String getPlayerType() {
        System.out.println("Choisissez le type de joueur (Human/AI): ");
        return scanner.nextLine();
    }
}