package player;

import model.Plateau;
import ui.InteractionUtilisateur;
import model.Player;
import model.State;


public class HumanPlayer implements Player {
    private final State state;
    private final InteractionUtilisateur interactionUtilisateur;

    public HumanPlayer(State state, InteractionUtilisateur interactionUtilisateur) {
        this.state = state;
        this.interactionUtilisateur = interactionUtilisateur;
    }

    @Override
    public State getState() {
        return state;
    }

    @Override
    public int[] makeMove(Plateau plateau) {
        // Demande uniquement le numéro de colonne
        System.out.println("Joueur " + state.getValue() + ", entrez la colonne (1 à " + plateau.getColonnes() + ") : ");
        int colonne = interactionUtilisateur.scanner.nextInt() - 1; // Soustraction pour passer de 1-7 à 0-6
        return new int[]{0, colonne}; // La ligne est déterminée par le plateau lors du placement
    }
}

