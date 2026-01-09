package rootfolder;

import rootfolder.canonique.*;

import java.util.Map;
import java.util.TreeMap;
import java.util.Queue;

public class MCanonique {

    public static Map<Integer, String> EncoderEncore(Map<Integer, String> tabCo){ //prend en argument une table de code d'une couleur

        Queue<TabCaEntree> fileTabCo = CodeLengthSorter.SortByLength(tabCo);
        //creation d'un dico
        Map<Integer, String> tabCanon= new TreeMap<>(); //la cle etant les valeurs, le tri des valeurs est automatique car Treemap 
        // DONC permet une table canonique triee par longueur de code puis valeur
        TabCaFinale.createTabCaFinale("0", fileTabCo, tabCanon);
        return tabCanon; 
        //resultat: une table canonique d'une couleur

    }

}