package model.board;

import model.etat.State;

public class GomokuBoard extends Board {
    public GomokuBoard() { super(15); }

    @Override
    public boolean placeToken(int x, int y, State state) {
        if (x < 0 || x >= size || y < 0 || y >= size || !cells[x][y].isEmpty()) {
            return false;
        }
        cells[x][y].setState(state);
        return true;
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
        for (int i = 0; i < 5; i++) {
            int r = row + i * dRow;
            int c = col + i * dCol;
            if (r < 0 || r >= size || c < 0 || c >= size || cells[r][c].getState() != state) {
                return false;
            }
        }
        return true;
    }
}