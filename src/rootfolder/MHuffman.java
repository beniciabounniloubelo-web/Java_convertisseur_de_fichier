package rootfolder; //indique le chemin de cette classe

import arbre.*; //car on utilise ce qu'il y a cet endroit

import java.lang.Comparable;
import java.util.Queue;
import java.util.PriorityQueue;
import java.util.Map;
import java.util.HashMap; 

public class MHuffman {

    public static Map<Integer, String> Encoder(int[] tf){ //prend en argument une table de frequence d'une couleur
        Noeud NoeudRacine = ArbreHuffman.construireArbre(tf); //ca donne un noeud
        Map<Integer, String> tabCo = new HashMap<>(); //creation du tableau de codes sous forme de dico
        ParcoursArbre.dfsRecursive(NoeudRacine, "", tabCo); //remplis le tableau de codes
        return tabCo;
        //resultat : une table de code sous forme de dico
    }

}


