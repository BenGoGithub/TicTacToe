package model.player;

import model.Move;
import model.board.Board;
import model.etat.State;

import java.util.Scanner;


public class HumanPlayer extends Player {
    private Scanner scanner;

    public HumanPlayer(String name, State symbol) {
        super(name, symbol);
        scanner = new Scanner(System.in);
    }

    @Override
    public Move makeMove(Board board) {
        System.out.println(name + ", entrez vos coordonnées (x y): ");
        int x = scanner.nextInt();
        int y = scanner.nextInt();
        return new Move(x, y);
    }
}