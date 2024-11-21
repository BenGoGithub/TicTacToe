package Player;

import java.util.Scanner;

public class HumanPlayer implements Player {
    private final String symbol;
    private final Scanner scanner;

    public HumanPlayer(String symbol) {
        this.symbol = symbol;
        this.scanner = new Scanner(System.in);
    }

    @Override
    public String getSymbol() {
        return symbol;
    }

    @Override
    public int[] makeMove(char[][] board) {
        int[] move = new int[2];
        boolean validMove = false;

        while (!validMove) {
            System.out.printf("Joueur %s, entrez le numéro de ligne (1 à 3) et la colonne (1 à 3) séparés d'un espace : ", symbol);
            String input = scanner.nextLine().trim();
            String[] inputs = input.split("\\s+");

            if (inputs.length != 2) {
                System.out.println("Veuillez entrer exactement deux nombres.");
                continue;
            }

            try {
                move[0] = Integer.parseInt(inputs[0]) - 1;
                move[1] = Integer.parseInt(inputs[1]) - 1;

                if (isValidMove(board, move[0], move[1])) {
                    validMove = true;
                } else {
                    System.out.println("Mouvement invalide. Réessayez.");
                }
            } catch (NumberFormatException e) {
                System.out.println("Entrée invalide. Veuillez entrer deux nombres entiers.");
            }
        }
        return move;
    }

    private boolean isValidMove(char[][] board, int row, int col) {
        return row >= 0 && row < 3 && col >= 0 && col < 3 && board[row][col] == ' ';
    }
}