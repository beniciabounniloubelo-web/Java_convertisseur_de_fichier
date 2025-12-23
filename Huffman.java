import java.lang.Comparable;
import java.util.Set;
import java.util.Queue;
import java.util.PriorityQueue;
import java.util.Map;

public class Huffman {
    
    public void Codage (Set<TabFreq> tf){
        Queue<Noeud> unefile=new PriorityQueue<>(); //une file de noeuds
        
        for (Map.Entry<Integer, Integer> entry : tf.getTab().entrySet()){ //on parcours le dico
            if (entree.getValue()>0){
                Noeud feuille=new Noeud(entree.getKey(), entree.getValue()); //prend en parametre les donnees d'une entree de la table de frequence
                unefile.add(feuille);
            }
        }

        while (unefile.size()>1){
        Noeud e1;
        Noeud e2;
        e1 = unefile.poll(); //variables qui recupere les 2 premiers noeuds de la file (celles avec la frequence la plus faible)
        e2 = unefile.poll();
        long newfrq = e1.getFrequence() + e2.getFrequence();
        Noeud node=new Noeud(newfrq, e1, e2);
        unefile.add(node);
        }

    }

}


