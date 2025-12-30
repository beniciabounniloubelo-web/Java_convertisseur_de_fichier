import java.lang.Comparable;
import java.util.Set;
import java.util.Queue;
import java.util.PriorityQueue;
import java.util.Map;

//on fait couleur par couleur

public class Huffman {

    public void Codage (???){
        //etape 1: creation de la file
        Queue<Noeud> unefile=new PriorityQueue<>(); //une file de noeuds
        
        for (int i=0; blablabla) //parcours le tableau (qui a été passé en argument)
        if (tab[i][1]>0){
        new Noeud (i, tab[i][1]); //pour chaque entree on va creer une feuille
        a chaque feuille on la place dans une file
        unefile.add(new Noeud (i, tab[i][1]);)}

        //etape 2: creation de l'arbre
        //ca c'est ok
        while (unefile.size()>1){ //il doit y avoir au moins 2 elements ds la file
            Noeud e1 = unefile.poll(); //variables qui recupere les 2 premiers noeuds de la file (celles avec la frequence la plus faible)
            Noeud e2 = unefile.poll();
            long newfrq = e1.getFrequence() + e2.getFrequence();
            Noeud node=new Noeud(newfrq, e1, e2);
            unefile.add(node);
        }

        //etape 3: parcours de l'arbre
    }

}


