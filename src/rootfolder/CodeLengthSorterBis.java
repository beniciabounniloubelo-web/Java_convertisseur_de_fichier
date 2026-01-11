package rootfolder;

import java.util.Map; 
import java.util.Queue; 
import java.util.PriorityQueue;

/**
 * La classe CodeLengthSorterBis trie les entrees d'une table de longueurs de codes en fonction de leur longueur.
 * <p>
 * Cette classe fournit une methode statique pour transformer une table associant des valeurs a leurs longueurs de code
 * en une file de priorite triee par longueur de code. Cela est utile pour la generation de codes canoniques de Huffman. Elle est utilisee specifiquement par {@link rootfolder.MCanoniqueBis}.
 * </p>
 */
public class CodeLengthSorterBis {

    /**
     * Cree une file de priorite triee par longueur de code a partir d'une table de longueurs de code.
     * <p>
     * Cette methode parcourt chaque entree de la table de longueurs, extrait la longueur de chaque code,
     * et cree une file de priorite triee par longueur de code.
     * </p>
     *
     * @param tabCanonLong une map associant chaque valeur a la longueur de son code
     * @return une file de priorite contenant des objets TabCaEntree tries par longueur de code
     */
    public static Queue<TabCaEntree> SortByLength(Map<Integer, Integer> tabCanonLong) {
        // Prend en argument une table de longueurs de code
        // Etape 1: creation de la file qui trie par longueur de code
        Queue<TabCaEntree> afile = new PriorityQueue<>(); // une file d'entree de la table de frequence
        for (Map.Entry<Integer, Integer> entree : tabCanonLong.entrySet()) { // on cree une file triee par longueur
            int k = entree.getKey();
            int v = entree.getValue(); // la difference est ici : on utilise directement la longueur du code
            afile.add(new TabCaEntree(k, v));
        }
        return afile;
    }
}
