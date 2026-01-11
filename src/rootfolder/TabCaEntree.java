package rootfolder;

/**
 * La classe TabCaEntree represente une entree pour une table de codes canoniques.
 * <p>
 * Chaque entree associe une valeur a la longueur de son code canonique.
 * Cette classe implemente l'interface {@link Comparable} afin de permettre
 * le tri des entrees par longueur de code, notamment lors de la construction
 * de la table de codes canoniques.
 * </p>
 */
public class TabCaEntree implements Comparable<TabCaEntree> {

    /**
     * Valeur associee a l'entree.
     */
    private int valeur; // valeur du pixel

    /**
     * Longueur du code canonique associe a la valeur.
     */
    private int longeurCode; // longueur de son code

    /**
     * Construit une entree pour une table de codes canoniques.
     *
     * @param v la valeur du pixel
     * @param lc la longueur du code canonique associe
     */
    TabCaEntree(int v, int lc) {
        this.valeur = v;
        this.longeurCode = lc;
    }

    /**
     * Compare deux entrees en fonction de la longueur de leur code.
     * <p>
     * Cette methode sert a ordonner les entrees dans une file lors de la construction
     * de la table de codes canoniques. Les entrees avec des codes plus courts ont
     * une priorite plus elevee.
     * </p>
     *
     * @param autre l'entree a comparer
     * @return une valeur negative, nulle ou positive selon que la longueur du code de cette entree
     *         est inferieure, egale ou superieure a celle de l'entree passee en parametre
     */
    @Override
    public int compareTo(TabCaEntree autre) {
        return Integer.compare(this.longeurCode, autre.longeurCode);
    }

    /**
     * Renvoie la valeur associee a cette entree.
     *
     * @return la valeur associee a cette entree
     */
    public int getValeur() {
        return valeur;
    }

    /**
     * Renvoie la longueur du code canonique associe a cette entree.
     *
     * @return la longueur du code canonique associe
     */
    public int getLongueurCode() {
        return longeurCode;
    }
}
