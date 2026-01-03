package rootfolder.arbre;

import java.util.Queue;
import java.util.PriorityQueue;

public class ArbreHuffman {

    public static Noeud construireArbre(int[] tf){ //n'importe quel tableau de frequence

        //etape 1: creation de la file
        Queue<Noeud> unefile=new PriorityQueue<>(); //une file de noeuds
        
        for (int i = 0; i < tf.length; i++) {
            if (tf[i] > 0) {
                unefile.add(new Noeud(i, tf[i]));
            }
        }

        //etape 2: creation de l'arbre
        while (unefile.size()>1){ //il doit y avoir au moins 2 elements ds la file
            Noeud e1 = unefile.poll(); //variables qui recupere les 2 premiers noeuds de la file (celles avec la frequence la plus faible)
            Noeud e2 = unefile.poll();
            long newfrq = e1.getFrequence() + e2.getFrequence();
            Noeud node=new Noeud(newfrq, e1, e2);
            unefile.add(node);
        }
        //a la fin de l'etape arbre = racine
        return unefile.poll();

    }

/*Note:
1. construction de l’arbre avec une file
2. MAIS file n'est pas l’arbre
3. file ne sert qu’à manipuler/construire/parcourir l’arbre mais c'est les liens entre les noeuds qui SONT l'arbre
*/
}
