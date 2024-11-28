import controller.ConnectFourController;
import controller.GameController;
import controller.GomokuController;
import controller.TicTacToeController;
import model.player.AIPlayer;
import model.player.HumanPlayer;
import model.player.Player;
import model.etat.State;
import view.UserInputView;


public class Main {
    public static void main(String[] args) {
        UserInputView inputView = new UserInputView();
        String gameType = inputView.getGameType();

        Player player1 = createPlayer("Joueur 1", State.X, inputView);
        Player player2 = createPlayer("Joueur 2", State.O, inputView);
        Player[] players = {player1, player2};

        GameController controller;
        switch (gameType.toLowerCase()) {
            case "tictactoe":
                controller = new TicTacToeController(players);
                break;
            case "connectfour":
                controller = new ConnectFourController(players);
                break;
            case "gomoku":
                controller = new GomokuController(players);
                break;
            default:
                System.out.println("Type de jeu non reconnu.");
                return;
        }

        controller.play();
    }

    private static Player createPlayer(String name, State symbol, UserInputView inputView) {
        String playerType = inputView.getPlayerType();
        if (playerType.equalsIgnoreCase("Human")) {
            return new HumanPlayer(name, symbol);
        } else if (playerType.equalsIgnoreCase("AI")) {
            return new AIPlayer(name, symbol);
        } else {
            System.out.println("Type de joueur non reconnu. Création d'un joueur humain par défaut.");
            return new HumanPlayer(name, symbol);
        }
    }
}