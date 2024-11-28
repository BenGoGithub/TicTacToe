package model.board;

import model.etat.State;

public class ConnectFourBoard extends Board {
    public ConnectFourBoard() { super(6); } // 6 rows, 7 columns typically

    @Override
    public boolean placeToken(int column, int y, State state) {
        if (column < 0 || column >= size || !cells[0][column].isEmpty()) {
            return false;
        }
        for (int row = size - 1; row >= 0; row--) {
            if (cells[row][column].isEmpty()) {
                cells[row][column].setState(state);
                return true;
            }
        }
        return false;
    }

    @Override
    public boolean checkWin(State state) {
        for (int row = 0; row < size; row++) {
            for (int col = 0; col < size; col++) {
                if (checkDirection(row, col, 1, 0, state) ||
                        checkDirection(row, col, 0, 1, state) ||
                        checkDirection(row, col, 1, 1, state) ||
                        checkDirection(row, col, 1, -1, state)) {
                    return true;
                }
            }
        }
        return false;
    }

    private boolean checkDirection(int row, int col, int dRow, int dCol, State state) {
        for (int i = 0; i < 4; i++) {
            int r = row + i * dRow;
            int c = col + i * dCol;
            if (r < 0 || r >= size || c < 0 || c >= size || cells[r][c].getState() != state) {
                return false;
            }
        }
        return true;
    }
}