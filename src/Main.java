import game.Jeu;
import game.Puissance4Jeu;
import game.TicTacToeJeu;
import model.Player;
import model.State;
import player.ArtificialPlayer;
import player.HumanPlayer;
import ui.InteractionUtilisateur;
import ui.View;


public class Main {
    public static void main(String[] args) {
        InteractionUtilisateur interactionUtilisateur = new InteractionUtilisateur();
        View view = new View();

        do {
            Jeu jeuChoisi = choisirJeu(interactionUtilisateur, view);
            jeuChoisi.jouer();
        } while (interactionUtilisateur.demanderRejouer());

        interactionUtilisateur.fermer();
    }

    private static Jeu choisirJeu(InteractionUtilisateur interactionUtilisateur, View view) {
        int choix = interactionUtilisateur.demanderChoixJeu();

        Player joueur1 = creerJoueur(State.X, interactionUtilisateur, 1);
        Player joueur2 = creerJoueur(State.O, interactionUtilisateur, 2);

        if (choix == 1) {
            return new TicTacToeJeu(joueur1, joueur2, view);
        } else {
            return new Puissance4Jeu(joueur1, joueur2, view);
        }
    }

    private static Player creerJoueur(State state, InteractionUtilisateur interactionUtilisateur, int numeroJoueur) {
        int typeJoueur = interactionUtilisateur.demanderTypeJoueur(numeroJoueur);
        return (typeJoueur == 1) ? new HumanPlayer(state, interactionUtilisateur) : new ArtificialPlayer(state);
    }
}