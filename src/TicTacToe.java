import java.util.Scanner;

public class TicTacToe {
    private static final int SIZE = 3;
    private final Cell[][] board;
    private Player currentPlayer;
    private Player player1;
    private Player player2;
    private final Scanner scanner;

    public TicTacToe() {
        board = new Cell[SIZE][SIZE];
        initializeBoard();
        player1 = new Player(" X ");
        player2 = new Player(" O ");
        currentPlayer = player1;
        scanner = new Scanner(System.in);
    }

    private void displayGameTitle() {
        // Codes de couleur ANSI
        final String RESET = "\u001B[0m";
        final String CYAN = "\u001B[36m";
        final String YELLOW = "\u001B[33m";
        final String BLUE = "\u001B[34m";
        final String BOLD = "\u001B[1m";

        System.out.println(CYAN + BOLD + "********************************" + RESET);
        System.out.println(CYAN + BOLD + "*                              *" + RESET);
        System.out.println(CYAN + BOLD + "*        " + YELLOW + "TIC-TAC-TOE" + CYAN + "           *" + RESET);
        System.out.println(CYAN + BOLD + "*         " + BLUE + "Version 1.0" + CYAN + "          *" + RESET);
        System.out.println(CYAN + BOLD + "*                              *" + RESET);
        System.out.println(CYAN + BOLD + "********************************" + RESET);
        System.out.println(YELLOW + "Joueur 1: X  |  Joueur 2: O" + RESET);
        System.out.println(BLUE + "Entrez les coordonnées (1-3) pour jouer" + RESET);
        System.out.println();
    }

    private void initializeBoard() {
        for (int i = 0; i < SIZE; i++) {
            for (int j = 0; j < SIZE; j++) {
                board[i][j] = new Cell();
            }
        }
    }

    public void play() {
        displayGameTitle();

        while (!isGameOver()) {
            playTurn();
        }

        display(); // Afficher le plateau final

        if (isWinner()) {
            switchPlayer(); // Revenir au joueur gagnant
            System.out.println("Le joueur " + currentPlayer.getRepresentation() + " a gagné !");
        } else {
            System.out.println("Match nul !");
        }
    }

    private void playTurn() {
        display();
        System.out.println("C'est au tour du joueur " + currentPlayer.getRepresentation());
        int[] move = getMoveFromPlayer();
        setOwner(move[0], move[1], currentPlayer);
        switchPlayer();
    }
    // Affiche le plateau de jeu
    private void display() {
        System.out.println("-------------");
        for (Cell[] row : board) {
            displayRow(row);
            System.out.println("-------------");
        }
    }
    // Affiche une ligne du plateau
    private void displayRow(Cell[] row) {
        System.out.print("|");
        for (Cell cell : row) {
            System.out.print(cell.getRepresentation() + "|");
        }
        System.out.println();
    }

    private int[] getMoveFromPlayer() {
        int[] move = new int[2]; //Tableau de
        boolean validMove = false;

        while (!validMove) {
            System.out.println("Entrez le numéro de ligne (1 à 3) et la colonne (1 à 3) séparés par un espace :");
            try {
                move[0] = scanner.nextInt() - 1;
                move[1] = scanner.nextInt() - 1;

                if (isValidMove(move[0], move[1])) {
                    validMove = true;
                } else {
                    System.out.println("Mouvement invalide. Réessayez.");
                }
            } catch (Exception e) {
                System.out.println("Entrée invalide. Veuillez entrer deux nombres entiers.");
                scanner.nextLine();
            }
        }
        return move;
    }

    private boolean isValidMove(int row, int col) {
        return row >= 0 && row < SIZE && col >= 0 && col < SIZE && board[row][col].isEmpty();
    }

    private void setOwner(int row, int col, Player player) {
        if (isValidMove(row, col)) {
            board[row][col].setOwner(player);
        } else {
            throw new IllegalArgumentException("Mouvement invalide");
        }
    }

    private void switchPlayer() {
        currentPlayer = (currentPlayer == player1) ? player2 : player1; // Condition vrai ? faux :
    }

    private boolean isGameOver() {
        return isWinner() || isBoardFull();
    }

    private boolean isWinner() {
        for (int i = 0; i < SIZE; i++) {
            if (checkLine(i, 0, 0, 1) || checkLine(0, i, 1, 0)) {
                return true;
            }
        }
        return checkLine(0, 0, 1, 1) || checkLine(0, SIZE - 1, 1, -1);
    }

    private boolean checkLine(int startRow, int startCol, int rowInc, int colInc) {
        Player firstPlayer = board[startRow][startCol].getOwner();
        if (firstPlayer == null) return false;

        for (int i = 1; i < SIZE; i++) {
            if (board[startRow + i * rowInc][startCol + i * colInc].getOwner() != firstPlayer) {
                return false;
            }
        }
        return true;
    }

    private boolean isBoardFull() {
        for (Cell[] row : board) {
            for (Cell cell : row) {
                if (cell.isEmpty()) {
                    return false;
                }
            }
        }
        return true;
    }
}