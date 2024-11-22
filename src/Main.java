import game.TicTacToe;
import model.Player;
import model.State;
import player.ArtificialPlayer;
import player.HumanPlayer;
import ui.InteractionUtilisateur;
import ui.View;


public static void main(String[] args) {
    jouerTicTacToe();
}

private static void jouerTicTacToe() {
    InteractionUtilisateur interactionUtilisateur = new InteractionUtilisateur();
    View view = new View();

    do {
        Player joueur1 = creerJoueur(State.X, interactionUtilisateur, 1);
        Player joueur2 = creerJoueur(State.O, interactionUtilisateur, 2);

        TicTacToe partie = new TicTacToe(joueur1, joueur2, view);
        partie.jouer();
    } while (interactionUtilisateur.demanderRejouer());

    interactionUtilisateur.fermer();
}

private static Player creerJoueur(State state, InteractionUtilisateur interactionUtilisateur, int numeroJoueur) {
    int typeJoueur = interactionUtilisateur.demanderTypeJoueur(numeroJoueur);
    return (typeJoueur == 1) ? new HumanPlayer(state, interactionUtilisateur) : new ArtificialPlayer(state);
}