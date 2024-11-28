package model.board;

import model.etat.State;
public class TicTacToeBoard extends Board {
    public TicTacToeBoard() { super(3); }

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
        for (int i = 0; i < size; i++) {
            if (checkLine(0, i, 1, 0, state) || checkLine(i, 0, 0, 1, state)) {
                return true;
            }
        }
        return checkLine(0, 0, 1, 1, state) || checkLine(0, 2, 1, -1, state);
    }

    private boolean checkLine(int startX, int startY, int dx, int dy, State state) {
        for (int i = 0; i < size; i++) {
            if (cells[startX + i * dx][startY + i * dy].getState() != state) {
                return false;
            }
        }
        return true;
    }
}