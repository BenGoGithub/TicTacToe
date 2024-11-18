import java.util.Scanner;

public class TicTacToe {
    private  static final int SIZE =3;
    private final Cell [][] board;
    private final Player player;
    private final Scanner scanner;

    public TicTacToe() {
        board = new Cell[SIZE][SIZE];
        initializeBoard();
        player = new Player(" X ");
        scanner = new Scanner(System.in);
    }
    private void initializeBoard() {
        for (int i = 0; i < SIZE; i++) {
            for (int j = 0; j < SIZE; j++) {
                board[i][j] = new Cell();
            }
        }
    }

public void display() {
    System.out.println("-------------");
    for (Cell[] row : board) {
        displayRow(row);
        System.out.println("-------------");
    }
}

private void displayRow(Cell[] row) {
    System.out.print("|");
    for (Cell cell : row) {
        System.out.print(cell.getRepresentation() + "|");
    }
    System.out.println();
}

public int[] getMoveFromPlayer() {
        int[] move = new int[2];
        boolean validMove = false;

        while (!validMove) {
            System.out.println("Entrez le numéro de ligne (0 à 2) et la colonne (0 à 2) séparés par un espace :");
            try {
                move[0] = scanner.nextInt();
                move[1] = scanner.nextInt();

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
    public void setOwner(int row, int col, Player player ) {
        if (isValidMove(row, col)) {
            board[row][col].setOwner(player);
        } else {
            throw new IllegalArgumentException("Mouvement invalide");
        }
    }

    public void playTurn() {
        display();
        int[] move = getMoveFromPlayer();
        setOwner(move[0], move[1], player);
    }
    public boolean isGameOver() {
        return isWinner() || isBoardFull();
    }

    private boolean isWinner() {
        // Vérifier les lignes, colonnes et diagonales
        // Retourner true si un joueur a gagné
        // Cette méthode nécessite une implémentation plus détaillée
        return false; // Pour l'instant, on retourne toujours false
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


