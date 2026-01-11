package rootfolder;

import java.util.Map; 
import java.util.Queue; 
import java.util.PriorityQueue;

/**
 * La classe CodeLengthSorter trie les entrees d'une table de codes en fonction de la longueur des codes.
 * <p>
 * Cette classe fournit une methode statique pour transformer une table de codes en une file de priorite
 * triee par longueur de code. Cela est utile pour la generation de codes canoniques de Huffman.
 * </p>
 */
public class CodeLengthSorter {

    /**
     * Cree une file de priorite triee par longueur de code a partir d'une table de codes.
     * <p>
     * Cette methode parcourt chaque entree de la table de codes, extrait la longueur de chaque code,
     * et cree une file de priorite triee par longueur de code.
     * </p>
     *
     * @param tableCode une map associant chaque valeur a son code
     * @return une file de priorite contenant des objets TabCaEntree tries par longueur de code
     */
    public static Queue<TabCaEntree> SortByLength(Map<Integer, String> tableCode) {
        // Prend en argument une table de code
        // Etape 1: creation de la file qui trie par longueur de code
        Queue<TabCaEntree> afile = new PriorityQueue<>(); // une file d'entree de la table de frequence
        for (Map.Entry<Integer, String> entree : tableCode.entrySet()) { // on cree une file triee par longueur
            int k = entree.getKey();
            int v = entree.getValue().length();
            afile.add(new TabCaEntree(k, v));
        }
        return afile;
    }
}
