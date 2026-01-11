package rootfolder;

import java.util.Map;
import java.util.TreeMap;
import java.util.Queue;

//creation de la table canonique finale

/**
 * La classe TabCaFinale gere la creation d'une table de codes canoniques de Huffman.
 *
 * Cette classe fournit une methode statique recursive pour generer les codes canoniques
 * a partir d'une file d'entrees triees par longueur de code. Les codes sont generes
 * en incrementant sequentiellement les valeurs binaires et en les completant avec des zeros
 * pour atteindre la longueur requise.
 */
public class TabCaFinale {

    /**
     * Cree recursivement une table de codes canoniques a partir d'une file d'entrees triees.
     *
     * Cette methode traite chaque entree de la file en generant un code binaire de la longueur
     * specifiee, en le completant avec des zeros si necessaire, et en l'ajoutant a la table de codes.
     * Le code suivant est genere en incrementant la valeur binaire du code precedent.
     *
     * @param code           le code binaire de depart ou le code genere pour l'entree precedente
     * @param afile          une file d'entrees triees par longueur de code
     * @param tabCanonique    la table de codes canoniques en cours de construction
     */
    public static void createTabCaFinale(String code, Queue<TabCaEntree> afile, Map<Integer, String> tabCanonique) {
        if (afile.isEmpty()) {
            // La fonction tourne jusqu'a ce que la file soit vide - condition d'arret
            return;
        }

        TabCaEntree e1 = afile.poll(); // On recupere une entree
        String newcode = code; // On recupere le code

        // On complete le code avec des zeros jusqu'a atteindre la longueur souhaitee
        while (newcode.length() < e1.getLongueurCode()) {
            newcode = newcode + "0";
        }

        if (newcode.length() == e1.getLongueurCode()) {
            // Si le code a la bonne longueur
            tabCanonique.put(e1.getValeur(), newcode); // Ajout dans la table de codes
        }

        // On cree le code pour la prochaine valeur
        int a = Integer.parseInt(newcode, 2); // On transforme le code (String) en entier
        a++; // On l'incremente
        String nextcode = Integer.toBinaryString(a); // On le repasse en String binaire

        createTabCaFinale(nextcode, afile, tabCanonique); // Appel recursif
    }
}
