package rootfolder;

import java.util.Map;
import java.util.HashMap;

//etape 3: parcours de l'arbre et creation de la table de code
//methode recurusive - usage de DFS
/**
 * La classe ParcoursArbre fournit des methodes pour parcourir un arbre de Huffman
 * et generer une table de codes binaires associes aux valeurs des feuilles.
 * <p>
 * Cette classe utilise un parcours en profondeur (DFS) pour explorer recursivement
 * l'arbre de Huffman et attribuer des codes binaires aux valeurs des feuilles.
 * Chaque branche gauche est associee a un '0' et chaque branche droite a un '1'.
 * </p>
 */
public class ParcoursArbre {

    /**
     * Parcourt recursivement un arbre de Huffman en utilisant un algorithme de parcours en profondeur (DFS)
     * pour construire une table de codes binaires associes aux valeurs des feuilles.
     * <p>
     * A chaque appel recursif, le code binaire est complete par '0' pour un deplacement vers la gauche
     * et par '1' pour un deplacement vers la droite.
     * </p>
     *
     * @param noeudActuel le noeud actuel de l'arbre de Huffman en cours de traitement
     * @param actualCode le code binaire accumule jusqu'au noeud actuel
     * @param tabCode la table de codes ou les valeurs des feuilles et leurs codes binaires associes sont stockes
     */
    public static void dfsRecursive(Noeud noeudActuel, String actualCode, Map<Integer, String> tabCode) {
        // Si le noeud actuel est une feuille, on ajoute son code a la table
        if (noeudActuel.getGauche() == null && noeudActuel.getDroit() == null) {
            int valeur = noeudActuel.getValeur();
            tabCode.put(valeur, actualCode); // Ajoute le code trouve pour la valeur de la feuille
            return;
        }

        // On se deplace sur l'enfant de gauche et on complete le code avec un '0'
        dfsRecursive(noeudActuel.getGauche(), actualCode + "0", tabCode);

        // On se deplace sur l'enfant de droite et on complete le code avec un '1'
        dfsRecursive(noeudActuel.getDroit(), actualCode + "1", tabCode);
    }
}
