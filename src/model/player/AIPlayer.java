package model.player;

import model.Move;
import model.board.Board;
import model.etat.State;
import java.util.Random;

public class AIPlayer extends Player {
    private Random random;

    public AIPlayer(String name, State symbol) {
        super(name, symbol);
        random = new Random();
    }

    @Override
    public Move makeMove(Board board) {
        int x, y;
        do {
            x = random.nextInt(board.getSize());
            y = random.nextInt(board.getSize());
        } while (!board.getCell(x, y).isEmpty());
        return new Move(x, y);
    }
}