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
        return interactionUtilisateur.demanderCoordonnees(state.getValue());
    }
}