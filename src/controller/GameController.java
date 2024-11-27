package controller;

import model.GameModel;
import model.HumanPlayer;
import model.Player;
import view.GameView;
import view.UserInputView;

public class GameController {
    private final GameModel model;
    private final GameView view;
    private final UserInputView inputView;

    public GameController(GameModel model, GameView view, UserInputView inputView) {
        this.model = model;
        this.view = view;
        this.inputView = inputView;
    }

    public void jouer() {
        do {
            partieUnique();
        } while (inputView.demanderRejouer());
    }

    private void partieUnique() {
        view.afficherPlateau(model.getPlateau());
        while (!model.estPartieTerminee()) {
            jouerTour();
            view.afficherPlateau(model.getPlateau());
            if (!model.estPartieTerminee()) {
                model.changerJoueur();
            }
        }
        gererFinPartie();
    }

    private void jouerTour() {
        Player joueurActuel = model.getJoueurActuel();
        view.afficherTourJoueur(joueurActuel.getNom());

        int[] coordonnees;
        boolean coupValide = false;
        while (!coupValide) {
            if (joueurActuel instanceof HumanPlayer) {
                coordonnees = inputView.demanderCoordonnees();
            } else {
                coordonnees = joueurActuel.makeMove(model.getPlateau());
            }
            coupValide = model.placerJeton(coordonnees[0], coordonnees[1]);
            if (!coupValide) view.afficherCoupInvalide();
        }
    }


    private void gererFinPartie() {
        if (model.estVictoire()) {
            view.afficherVictoire(model.getGagnant().getNom());
        } else if (model.estMatchNul()) {
            view.afficherMatchNul();
        }
    }
}