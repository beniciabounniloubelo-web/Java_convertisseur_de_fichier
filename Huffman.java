import java.util.*;

public class Huffman {
    
    public void Codage (Set<TabFreq> tf){
        Queue<Noeud> unefile=new PriorityQueue<>(); //une file de noeuds
        
        for (TabFreq entree : tf){
            if (entree.getValue()>0){
                Noeud feuille=new Noeud(entry.getKey(), entry.getValue()); //prend en parametre les donnees d'une entree de la table de frequence
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


