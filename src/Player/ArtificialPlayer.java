package Player;

import java.security.SecureRandom;

public class ArtificialPlayer implements Player {
    private final String symbol;
    private final SecureRandom random;

    public ArtificialPlayer(String symbol) {
        this.symbol = symbol;
        this.random = new SecureRandom();
    }

    @Override
    public String getSymbol() {
        return symbol;
    }

    @Override
    public int[] makeMove(char[][] board) {
        int[] move = new int[2];
        do {
            move[0] = random.nextInt(3);
            move[1] = random.nextInt(3);
        } while (board[move[0]][move[1]] != ' ');
        return move;
    }
}