import Player.Player;

/**
 * Représente une cellule individuelle sur le plateau de jeu Tic-Tac-Toe.
 */
public class Cell {
    private Player owner;

    /**
     * Retourne la représentation visuelle de la cellule.
     *
     * @return Le symbole du joueur qui possède la cellule, ou un espace si la cellule est vide.
     */
    public String getRepresentation() {
        return owner == null ? " " : owner.getSymbol();
    }

    /**
     * Définit le propriétaire de la cellule.
     *
     * @param player Le joueur qui prend possession de la cellule.
     */
    public void setOwner(Player player) {
        this.owner = player;
    }

    /**
     * Vérifie si la cellule est vide.
     *
     * @return true si la cellule n'a pas de propriétaire, false sinon.
     */
    public boolean isEmpty() {
        return owner == null;
    }

    /**
     * Retourne le propriétaire actuel de la cellule.
     *
     * @return Le joueur qui possède la cellule, ou null si la cellule est vide.
     */
    public Player getOwner() {
        return owner;
    }
}