package view;

import model.board.Board;


public class GameView {
    public void displayBoard(Board board) {
        for (int i = 0; i < board.getSize(); i++) {
            for (int j = 0; j < board.getSize(); j++) {
                System.out.print(board.getCell(i, j).getState() + " ");
            }
            System.out.println();
        }
        System.out.println();
    }
}