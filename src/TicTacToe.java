import java.util.Arrays;
import java.util.stream.IntStream;

import Player.Player;


public class TicTacToe {
    private static final int SIZE = 3;
    private final Cell[][] board;
    private Player currentPlayer;
    private final Player player1;
    private final Player player2;

    public TicTacToe(Player player1, Player player2) {
        this.board = new Cell[SIZE][SIZE];
        initializeBoard();
        this.player1 = player1;
        this.player2 = player2;
        this.currentPlayer = player1;
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
        System.out.println(YELLOW + "Joueur 1: " + player1.getSymbol() + "  |  Joueur 2: " + player2.getSymbol() + RESET);
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
            System.out.println("Le joueur " + currentPlayer.getSymbol() + " a gagné !");
        } else {
            System.out.println("Match nul !");
        }
    }

    public void playTurn() {
        display();
        System.out.println("C'est au tour du joueur " + currentPlayer.getSymbol());
        int[] move;
        do {
            move = currentPlayer.makeMove(getBoardAsCharArray());
            if (isInvalidMove(move[0], move[1])) {
                System.out.println("Mouvement invalide. Réessayez.");
            }
        } while (isInvalidMove(move[0], move[1]));

        setOwner(move[0], move[1], currentPlayer);
        switchPlayer();
    }

    private void display() {
        System.out.println("-------------");
        for (Cell[] row : board) {
            System.out.println("|" + Arrays.stream(row)
                    .map(Cell::getRepresentation)
                    .reduce((a, b) -> a + "|" + b)
                    .orElse("") + "|");
            System.out.println("-------------");
        }
    }

    public boolean isInvalidMove(int row, int col) {
        return row < 0 || row >= SIZE || col < 0 || col >= SIZE || !board[row][col].isEmpty();
    }

    private void setOwner(int row, int col, Player player) {
        board[row][col].setOwner(player);
    }

    private void switchPlayer() {
        currentPlayer = (currentPlayer == player1) ? player2 : player1;
    }

    private boolean isGameOver() {
        return isWinner() || isBoardFull();
    }

    private boolean isWinner() {
        return IntStream.range(0, SIZE).anyMatch(i -> checkLine(i, 0, 0, 1) || checkLine(0, i, 1, 0))
                || checkLine(0, 0, 1, 1) || checkLine(0, SIZE - 1, 1, -1);
    }

    private boolean checkLine(int startRow, int startCol, int rowInc, int colInc) {
        Player firstPlayer = board[startRow][startCol].getOwner();
        return firstPlayer != null && IntStream.range(1, SIZE)
                .allMatch(i -> board[startRow + i * rowInc][startCol + i * colInc].getOwner() == firstPlayer);
    }

    private boolean isBoardFull() {
        return Arrays.stream(board).flatMap(Arrays::stream).noneMatch(Cell::isEmpty);
    }

    public char[][] getBoardAsCharArray() {
        char[][] charBoard = new char[SIZE][SIZE];
        for (int i = 0; i < SIZE; i++) {
            for (int j = 0; j < SIZE; j++) {
                Player owner = board[i][j].getOwner();
                charBoard[i][j] = owner == null ? ' ' : owner.getSymbol().charAt(0);
            }
        }
        return charBoard;
    }
}