package rootfolder;

import java.util.Map;
import java.util.TreeMap;
import java.util.Queue;

/**
 * La classe MCanoniqueBis fournit des methodes pour generer une table de codes canoniques
 * a partir d'une table de longueurs de codes. Elle est utilisee specifiquement par {@link rootfolder.PifReader}.
 * <p>
 * Cette classe permet de transformer une table associant des valeurs a leurs longueurs de code
 * en une table de codes canoniques, en triant les codes par longueur puis par valeur.
 * </p>
 */
public class MCanoniqueBis {

    /**
     * Genere une table de codes canoniques a partir d'une table de longueurs de code.
     * <p>
     * Cette methode trie les entrees par longueur de code, puis genere les codes canoniques
     * en utilisant une file de priorite et une table triee par valeur.
     * </p>
     *
     * @param tabCanonLong une table associant chaque valeur a la longueur de son code canonique
     * @return une table de codes canoniques triee par longueur de code puis par valeur,
     *         ou les codes binaires sont les cles et les valeurs sont les entiers associes
     */
    public static Map<String, Integer> EncoderEncore(Map<Integer, Integer> tabCanonLong) {
        // Trie les entrees de la table de longueurs de code
        Queue<TabCaEntree> fileTabCanon = CodeLengthSorterBis.SortByLength(tabCanonLong);

        // Creation d'une table canonique triee par valeur
        Map<String, Integer> tabCanon = new TreeMap<>();
        // Permet une table canonique triee par longueur de code puis par valeur

        TabCaFinaleBis.createTabCaFinale(0, fileTabCanon, tabCanon);
        return tabCanon;
    }
}
