package model.board;

import model.Cell;
import model.etat.State;

public abstract class Board {
    protected Cell[][] cells;
    protected int size;

    public Board(int size) {
        this.size = size;
        cells = new Cell[size][size];
        initializeBoard();
    }

    private void initializeBoard() {
        for (int i = 0; i < size; i++) {
            for (int j = 0; j < size; j++) {
                cells[i][j] = new Cell(i, j);
            }
        }
    }

    public abstract boolean placeToken(int x, int y, State state);
    public abstract boolean checkWin(State state);

    public boolean isFull() {
        for (Cell[] row : cells) {
            for (Cell cell : row) {
                if (cell.isEmpty()) return false;
            }
        }
        return true;
    }

    public Cell getCell(int x, int y) { return cells[x][y]; }
    public int getSize() { return size; }

    public String getBoardRepresentation() {
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < size; i++) {
            for (int j = 0; j < size; j++) {
                sb.append(cells[i][j].getState()).append(" ");
            }
            sb.append("\n");
        }
        return sb.toString();
    }
}