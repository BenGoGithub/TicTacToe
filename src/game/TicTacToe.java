package game;
import model.Player;
import ui.View;
import model.State;



public class TicTacToe {
    private static final int TAILLE_PLATEAU = 3;
    private final State[][] plateau;
    private Player joueurCourant;
    private final Player joueur1;
    private final Player joueur2;
    private final View view;

    public TicTacToe(Player joueur1, Player joueur2, View view) {
        this.plateau = new State[TAILLE_PLATEAU][TAILLE_PLATEAU];
        initialiserPlateau();
        this.joueur1 = joueur1;
        this.joueur2 = joueur2;
        this.joueurCourant = joueur1;
        this.view = view;
    }

    public void jouer() {
        view.afficherTitre();

        while (!estPartieTerminee()) {
            jouerTour();
        }

        view.afficherPlateau(plateau);

        if (estGagnantExiste()) {
            changerJoueur();
            view.afficherVictoire(joueurCourant.getState().getValue());
        } else {
            view.afficherMatchNul();
        }
    }

    private void initialiserPlateau() {
        for (int i = 0; i < TAILLE_PLATEAU; i++) {
            for (int j = 0; j < TAILLE_PLATEAU; j++) {
                plateau[i][j] = State.EMPTY;
            }
        }
    }

    private void jouerTour() {
        view.afficherPlateau(plateau);
        view.afficherTourJoueur(joueurCourant.getState().getValue());

        int[] coup;
        do {
            coup = joueurCourant.makeMove(plateau);
        } while (estCoupInvalide(coup[0], coup[1]));

        plateau[coup[0]][coup[1]] = joueurCourant.getState();
        changerJoueur();
    }

    private boolean estCoupInvalide(int ligne, int colonne) {
        return ligne < 0 || ligne >= TAILLE_PLATEAU || colonne < 0 || colonne >= TAILLE_PLATEAU || plateau[ligne][colonne] != State.EMPTY;
    }

    private void changerJoueur() {
        joueurCourant = (joueurCourant == joueur1) ? joueur2 : joueur1;
    }

    private boolean estPartieTerminee() {
        return estGagnantExiste() || estPlateauPlein();
    }

    private boolean estGagnantExiste() {
        return verifierLignes() || verifierColonnes() || verifierDiagonales();
    }

    private boolean verifierLignes() {
        for (int i = 0; i < TAILLE_PLATEAU; i++) {
            if (verifierLigne(i)) return true;
        }
        return false;
    }

    private boolean verifierColonnes() {
        for (int i = 0; i < TAILLE_PLATEAU; i++) {
            if (verifierColonne(i)) return true;
        }
        return false;
    }

    private boolean verifierDiagonales() {
        return verifierDiagonalePrincipale() || verifierDiagonaleSecondaire();
    }

    private boolean verifierLigne(int ligne) {
        State premierEtat = plateau[ligne][0];
        if (premierEtat == State.EMPTY) return false;
        for (int j = 1; j < TAILLE_PLATEAU; j++) {
            if (plateau[ligne][j] != premierEtat) return false;
        }
        return true;
    }

    private boolean verifierColonne(int colonne) {
        State premierEtat = plateau[0][colonne];
        if (premierEtat == State.EMPTY) return false;
        for (int i = 1; i < TAILLE_PLATEAU; i++) {
            if (plateau[i][colonne] != premierEtat) return false;
        }
        return true;
    }

    private boolean verifierDiagonalePrincipale() {
        State premierEtat = plateau[0][0];
        if (premierEtat == State.EMPTY) return false;
        for (int i = 1; i < TAILLE_PLATEAU; i++) {
            if (plateau[i][i] != premierEtat) return false;
        }
        return true;
    }

    private boolean verifierDiagonaleSecondaire() {
        State premierEtat = plateau[0][TAILLE_PLATEAU - 1];
        if (premierEtat == State.EMPTY) return false;
        for (int i = 1; i < TAILLE_PLATEAU; i++) {
            if (plateau[i][TAILLE_PLATEAU - 1 - i] != premierEtat) return false;
        }
        return true;
    }

    private boolean estPlateauPlein() {
        for (State[] ligne : plateau) {
            for (State cellule : ligne) {
                if (cellule == State.EMPTY) return false;
            }
        }
        return true;
    }
}
