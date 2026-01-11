package rootfolder;

import java.util.Map;
import java.util.TreeMap;
import java.util.Queue;

//creation de la table canonique finale
//code = code de depart soit 0

/**
 * La classe TabCaFinaleBis gere la creation d'une table de codes canoniques de Huffman.
 *
 * Cette classe fournit une methode statique recursive pour generer les codes canoniques
 * a partir d'une file d'entrees triees par longueur de code. Les codes sont generes
 * en incrementant sequentiellement les valeurs binaires et en les completant avec des zeros
 * en tete pour atteindre la longueur requise. Elle est utilisee specifiquement par
 * {@link rootfolder.MCanoniqueBis}.
 */
public class TabCaFinaleBis {

    /**
     * Cree recursivement une table de codes canoniques a partir d'une file d'entrees triees.
     *
     * Cette methode traite chaque entree de la file en generant un code binaire de la longueur
     * specifiee, en le completant avec des zeros en tete si necessaire, et en l'ajoutant a la table de codes.
     * Le code suivant est genere en incrementant la valeur binaire du code precedent.
     *
     * @param code           le code binaire de depart sous forme d'entier
     * @param afile          une file d'entrees triees par longueur de code
     * @param tabCanonique    la table de codes canoniques en cours de construction, associant chaque code binaire
     *                       a sa valeur correspondante
     */
    public static void createTabCaFinale(int code, Queue<TabCaEntree> afile, Map<String, Integer> tabCanonique) {
        if (afile.isEmpty()) {
            // La fonction tourne jusqu'a ce que la file soit vide - condition d'arret
            return;
        }

        TabCaEntree e1 = afile.poll(); // On recupere une entree
        String newcode = Integer.toBinaryString(code); // On recupere le code sous forme binaire

        // On complete le code avec des zeros en tete jusqu'a atteindre la longueur souhaitee
        while (newcode.length() < e1.getLongueurCode()) {
            newcode = "0" + newcode; // Ajout des zeros en tete
        }

        if (newcode.length() == e1.getLongueurCode()) {
            // Si le code a la bonne longueur
            tabCanonique.put(newcode, e1.getValeur()); // Ajout dans la table de codes
        }

        // On cree le code pour la prochaine valeur
        int nextcode = Integer.parseInt(newcode, 2); // On transforme le code (String) en entier
        nextcode++; // On l'incremente

        createTabCaFinale(nextcode, afile, tabCanonique); // Appel recursif
    }
}
