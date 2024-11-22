package game;

import model.Player;
import ui.View;

public class TicTacToeJeu implements Jeu {
    private final TicTacToe plateau;
    private final Player joueur1;
    private final Player joueur2;
    private final View view;

    public TicTacToeJeu(Player joueur1, Player joueur2, View view) {
        this.plateau = new TicTacToe();
        this.joueur1 = joueur1;
        this.joueur2 = joueur2;
        this.view = view;
    }

    @Override
    public void jouer() {
        Player joueurCourant = joueur1;
        while (true) {
            view.afficherPlateau(plateau);
            int[] coup = joueurCourant.makeMove(plateau);
            if (plateau.placerJeton(coup[1], joueurCourant.getState())) {
                if (plateau.estVictoire(joueurCourant.getState())) {
                    view.afficherPlateau(plateau);
                    view.afficherVictoire(joueurCourant.getState().getValue());
                    break;
                } else if (plateau.estPlein()) {
                    view.afficherPlateau(plateau);
                    view.afficherMatchNul();
                    break;
                }
                joueurCourant = (joueurCourant == joueur1) ? joueur2 : joueur1;
            } else {
                view.afficherCoupInvalide();
            }
        }
    }

    @Override
    public String getNom() {
        return "Tic-Tac-Toe";
    }
}