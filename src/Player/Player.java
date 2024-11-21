package Player;

/**
 * Interface représentant un joueur dans le jeu Tic-Tac-Toe.
 * Cette interface définit les méthodes essentielles que chaque type de joueur doit implémenter.
 */
public interface Player {

    /**
     * Retourne le symbole représentant le joueur sur le plateau de jeu.
     *
     * @return Une chaîne de caractères représentant le symbole du joueur (généralement "X" ou "O").
     */
    String getSymbol();

    /**
     * Détermine et retourne le prochain mouvement du joueur.
     *
     * @param board Le plateau de jeu actuel, représenté par un tableau 2D de caractères.
     * @return Un tableau de deux entiers représentant les coordonnées [ligne, colonne] du mouvement choisi.
     *         Les indices sont basés sur zéro, donc les valeurs valides sont 0, 1, ou 2.
     */
    int[] makeMove(char[][] board);
}