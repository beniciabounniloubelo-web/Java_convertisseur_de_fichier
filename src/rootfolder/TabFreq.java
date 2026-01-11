package rootfolder;

import java.util.Map;
import java.util.TreeMap;
import java.awt.image.*;
import java.awt.Color;

//on cree ici les 3 tables (qui vont etre return par la suite)

/**
 * La classe TabFreq gere le calcul des frequences des composantes de couleur (rouge, vert, bleu)
 * d'une image donnee.
 * <p>
 * Cette classe fournit une methode statique pour remplir des tableaux de frequences
 * en analysant chaque pixel d'une image et en comptant les occurrences de chaque valeur
 * pour les composantes rouge, vert et bleu.
 * </p>
 */
public class TabFreq {

    /**
     * Remplit les tableaux de frequences des composantes de couleur (rouge, vert, bleu)
     * d'une image donnee.
     * <p>
     * Cette methode parcourt chaque pixel de l'image, extrait les valeurs des composantes
     * rouge, vert et bleu, et met a jour les tableaux de frequences correspondants.
     * </p>
     *
     * @param img l'image a analyser
     * @return un objet TroisCouleurs contenant les tableaux de frequences pour les composantes
     *         rouge, vert et bleu
     */
    public static TroisCouleurs RemplirTabFreq(BufferedImage img) {
        int[] tableau1 = new int[256]; // rouge
        int[] tableau2 = new int[256]; // vert
        int[] tableau3 = new int[256]; // bleu

        for (int L = 0; L < img.getWidth(); L++) { // parcours en largeur de l'image
            for (int h = 0; h < img.getHeight(); h++) { // parcours en hauteur de l'image
                int rgb = img.getRGB(L, h); // on recupere la valeur RGB d'un pixel
                Color couleur = new Color(rgb);
                // il n'y a que l'objet Color qui peut decoder le nombre RGB et le traduire en couleur

                tableau1[couleur.getRed()]++; // on met a jour la frequence dans le tableau rouge
                tableau2[couleur.getGreen()]++;
                tableau3[couleur.getBlue()]++;
            }
        }

        return new TroisCouleurs(tableau1, tableau2, tableau3);
    }
}
