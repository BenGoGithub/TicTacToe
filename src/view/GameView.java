package view;

import model.board.Board;
import model.player.Player;


public class GameView {
    public void displayBoard(Board board) {
        System.out.println(board.getBoardRepresentation());
    }

    public void displayTurn(Player player) {
        System.out.println("C'est au tour de " + player.getName() + " (" + player.getSymbol() + ")");
    }

    public void displayWinner(Player player) {
        System.out.println("Le joueur " + player.getName() + " (" + player.getSymbol() + ") a gagné !");
    }

    public void displayDraw() {
        System.out.println("Match nul !");
    }

    public void displayInvalidMove() {
        System.out.println("Coup invalide ! Réessayez.");
    }
    public void displayGameStart(Player player) {
        System.out.println("Le jeu commence. C'est au tour du premier joueur : " + player.getName() + " (" + player.getSymbol() + ")");
    }
}