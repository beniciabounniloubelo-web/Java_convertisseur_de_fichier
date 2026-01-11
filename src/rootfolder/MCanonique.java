package rootfolder;

import java.util.Map;
import java.util.TreeMap;
import java.util.Queue;

/**
 * La classe MCanonique fournit des methodes pour encoder une table de codes
 * en une table de codes canoniques de Huffman.
 * <p>
 * Cette classe permet de transformer une table de codes de Huffman en une table de codes canoniques,
 * en triant les codes par longueur puis par valeur.
 * </p>
 */
public class MCanonique {

    /**
     * Encode une table de codes de Huffman en une table de codes canoniques.
     * <p>
     * Cette methode trie les codes par longueur, puis genere les codes canoniques
     * en utilisant une file de priorite et une table triee par valeur.
     * </p>
     *
     * @param tabCo une table de codes de Huffman associee a une composante de couleur
     * @return une table de codes canoniques triee par longueur de code puis par valeur
     */
    public static Map<Integer, String> EncoderEncore(Map<Integer, String> tabCo) {
        // Trie les entrees de la table de codes par longueur de code
        Queue<TabCaEntree> fileTabCo = CodeLengthSorter.SortByLength(tabCo);

        // Creation d'une table canonique triee par valeur
        Map<Integer, String> tabCanon = new TreeMap<>();
        // Permet une table canonique triee par longueur de code puis par valeur

        TabCaFinale.createTabCaFinale("0", fileTabCo, tabCanon);
        return tabCanon;
    }
}
