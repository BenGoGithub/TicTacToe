public class TicTacToe {
    private  static final int SIZE =3;
    private final Cell [][] board;

    public TicTacToe() {
        board = new Cell[SIZE][SIZE];
        initializeBoard();
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
}