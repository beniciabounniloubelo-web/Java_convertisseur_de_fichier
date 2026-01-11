package rootfolder;

import java.io.DataOutputStream; 
import java.io.IOException;      
import java.util.Map;           
import java.util.TreeMap;

/**
 * La classe TabCanoWriter permet d'ecrire une table canonique dans un flux de sortie.
 * <p>
 * Cette classe ecrit les longueurs des codes canoniques associes a chaque valeur
 * dans un flux de sortie binaire. Les valeurs manquantes sont comblees par des zeros.
 * </p>
 */
public class TabCanoWriter {

    /**
     * Ecrit une table canonique dans un flux de sortie.
     * <p>
     * Pour chaque entree de la table, cette methode ecrit des zeros pour les cles manquantes
     * avant la cle actuelle, puis ecrit la longueur du code canonique associe a la cle.
     * Si la table ne contient pas toutes les cles possibles (0 a 255), les cles manquantes
     * a la fin sont comblees par des zeros.
     * </p>
     *
     * @param dos le flux de sortie ou la table canonique sera ecrite
     * @param tableCano la table canonique a ecrire, associant chaque valeur a son code canonique
     * @throws IOException si une erreur survient lors de l'ecriture dans le flux
     */
    public void ecrireTableCanonique(DataOutputStream dos, Map<Integer, String> tableCano) throws IOException {
        int i = 0;

        for (Map.Entry<Integer, String> entree : tableCano.entrySet()) {
            // Ecrit des 0 pour toutes les cles manquantes avant la cle actuelle
            while (i < entree.getKey()) {
                dos.writeByte(0);
                i++;
            }
            // Ecrit la longueur du code actuel
            dos.writeByte(entree.getValue().length());
            i++;
        }
        // Complete si la Map n'a pas toutes les cles
        while (i < 256) {
            dos.writeByte(0);
            i++;
        }
    }
}
