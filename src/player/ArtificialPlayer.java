package player;

import model.Player;
import model.State;

import java.util.Random;

public class ArtificialPlayer implements Player {
    private final State state;
    private final Random random;

    public ArtificialPlayer(State state) {
        this.state = state;
        this.random = new Random();
    }

    @Override
    public State getState() {
        return state;
    }

    @Override
    public int[] makeMove(State[][] board) {
        int row, col;
        do {
            row = random.nextInt(3);
            col = random.nextInt(3);
        } while (board[row][col] != State.EMPTY);
        return new int[]{row, col};
    }
}