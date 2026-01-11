package rootfolder;

//objet pour acceder au 3 tableaux de couleur


/**
 * La classe TroisCouleurs stocke les tableaux de frequences des trois composantes de couleur (rouge, vert, bleu)
 * d'une image.
 * <p>
 * Cette classe permet de regrouper les tableaux de frequences des trois canaux de couleur
 * afin de faciliter leur manipulation et leur transmission entre differentes methodes.
 * </p>
 */
public class TroisCouleurs {

    /**
     * Tableau de frequences pour la composante rouge.
     */
    private int[] rouge;

    /**
     * Tableau de frequences pour la composante verte.
     */
    private int[] vert;

    /**
     * Tableau de frequences pour la composante bleue.
     */
    private int[] bleu;

    /**
     * Construit un objet TroisCouleurs a partir des tableaux de frequences des trois composantes.
     *
     * @param r tableau de frequences pour la composante rouge
     * @param g tableau de frequences pour la composante verte
     * @param b tableau de frequences pour la composante bleue
     */
    public TroisCouleurs(int[] r, int[] g, int[] b) {
        this.rouge = r;
        this.vert = g;
        this.bleu = b;
    }

    /**
     * Retourne le tableau de frequences de la composante rouge.
     *
     * @return le tableau de frequences de la composante rouge
     */
    public int[] getRouge() {
        return this.rouge;
    }

    /**
     * Retourne le tableau de frequences de la composante verte.
     *
     * @return le tableau de frequences de la composante verte
     */
    public int[] getVert() {
        return this.vert;
    }

    /**
     * Retourne le tableau de frequences de la composante bleue.
     *
     * @return le tableau de frequences de la composante bleue
     */
    public int[] getBleu() {
        return this.bleu;
    }
}
