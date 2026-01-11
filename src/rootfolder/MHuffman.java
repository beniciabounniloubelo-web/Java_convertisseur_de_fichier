package rootfolder;

import java.lang.Comparable;
import java.util.Queue;
import java.util.PriorityQueue;
import java.util.Map;
import java.util.HashMap; 

/**
 * La classe MHuffman fournit des methodes pour encoder une table de frequences
 * en une table de codes de Huffman.
 * <p>
 * Cette classe permet de construire un arbre de Huffman a partir d'une table de frequences
 * et de generer les codes binaires associes a chaque valeur.
 * </p>
 */
public class MHuffman {

    /**
     * Encode une table de frequences en une table de codes de Huffman.
     * <p>
     * Cette methode construit un arbre de Huffman a partir des frequences fournies,
     * puis parcourt l'arbre pour generer les codes binaires associes a chaque valeur.
     * </p>
     *
     * @param tf une table de frequences associee a une composante de couleur
     * @return une table de codes de Huffman, ou chaque valeur est associee a son code binaire
     */
    public static Map<Integer, String> Encoder(int[] tf) {
        // Construit l'arbre de Huffman a partir de la table de frequences
        Noeud noeudRacine = ArbreHuffman.construireArbre(tf);

        // Creation d'une table de codes sous forme de dictionnaire
        Map<Integer, String> tabCo = new HashMap<>();

        // Remplit la table de codes en parcourant l'arbre de Huffman
        ParcoursArbre.dfsRecursive(noeudRacine, "", tabCo);

        return tabCo;
    }
}
