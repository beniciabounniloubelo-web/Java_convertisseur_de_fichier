package rootfolder.canonique;

import java.util.Map; 
import java.util.Queue; 
import java.util.PriorityQueue;

public class CodeLengthSorter{ 
    public static Queue<TabCaEntree> SortByLength(Map<Integer, String> tableCode){ 
        //prend en argument une table de code 
        //etape 1: creation de la file qui trie par longueur de code 
        Queue<TabCaEntree> afile=new PriorityQueue<>(); //une file d'entree de la table de frequence 
        for (Map.Entry<Integer, String> entree : tableCode.entrySet()) { //on cree une file triee par longueur 
            int k = entree.getKey(); 
            int v = entree.getValue().length(); 
            afile.add(new TabCaEntree(k,v)); 
        } 
        return afile; 
    } 
}