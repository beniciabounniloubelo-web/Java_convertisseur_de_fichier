package rootfolder;

import java.util.Queue;
import java.util.PriorityQueue;

/*Note:
1. construction de l’arbre avec une file
2. MAIS file n'est pas l’arbre
3. file ne sert qu’à manipuler/construire/parcourir l’arbre mais c'est les liens entre les noeuds qui SONT l'arbre
*/

/**
 * La classe ArbreHuffman permet de construire un arbre binaire de Huffman a partir d'un tableau de frequences.
 * <p>
 * Cette classe fournit une methode statique pour construire un arbre de Huffman,
 * utilise pour la compression de donnees en attribuant des codes plus courts aux valeurs les plus frequentes.
 * </p>
 */
public class ArbreHuffman {

    /**
     * Construit un arbre de Huffman a partir d'un tableau de frequences.
     * Cette methode suit les etapes suivantes :
     * <ol>
     *   <li>Cree une file de priorite contenant les noeuds feuilles, un noeud par valeur de frequence non nulle.</li>
     *   <li>Fusionne les deux noeuds de plus faible frequence en un nouveau noeud interne,
     *   jusqu'a ce qu'il ne reste qu'un seul noeud dans la file, qui devient la racine de l'arbre.</li>
     * </ol>
     *
     * @param tf un tableau de frequences ou chaque indice represent une valeur et la valeur a cet indice
     *          represent sa frequence d'apparition
     * @return le noeud racine de l'arbre de Huffman construit
     */
    public static Noeud construireArbre(int[] tf) {

        // Etape 1: creation de la file
        Queue<Noeud> unefile = new PriorityQueue<>(); // une file de noeuds

        for (int i = 0; i < tf.length; i++) {
            if (tf[i] > 0) {
                unefile.add(new Noeud(i, tf[i]));
            }
        }

        // Etape 2: creation de l'arbre
        while (unefile.size() > 1) { // il doit y avoir au moins 2 elements dans la file
            Noeud e1 = unefile.poll(); // recuperer les 2 premiers noeuds de la file (ceux avec la frequence la plus faible)
            Noeud e2 = unefile.poll();
            long newfrq = e1.getFrequence() + e2.getFrequence();
            Noeud node = new Noeud(newfrq, e1, e2);
            unefile.add(node);
        }
        // A la fin de l'etape, l'arbre est reduit a sa racine
        return unefile.poll();
    }
}
