import controller.GameController;
import model.*;
import view.GameView;
import view.UserInputView;


public class GameManager {
    public static void main(String[] args) {
        UserInputView inputView = new UserInputView();

        Player joueur1 = creerJoueur(State.X, "Joueur 1", inputView);
        Player joueur2 = creerJoueur(State.O, "Joueur 2", inputView);

        GameModel model = new GameModel(joueur1, joueur2);
        GameView view = new GameView();

        GameController controller = new GameController(model, view, inputView);
        controller.jouer();
    }

    private static Player creerJoueur(State symbole, String nom, UserInputView inputView) {
        if (inputView.choisirJoueurHumain(symbole == State.X ? 1 : 2)) {
            return new HumanPlayer(symbole, nom);
        } else {
            return new AIPlayer(symbole, nom);
        }
    }
}