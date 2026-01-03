package rootfolder; //indique le chemin de cette classe

import rootfolder.arbre.*; //car on utilise ce qu'il y a cet endroit

import java.lang.Comparable;
import java.util.Queue;
import java.util.PriorityQueue;
import java.util.Map;
import java.util.HashMap;

/* Dans un Main
BufferedImage img = ImageIO.read(new File "nomdelimage.pif"); //on chargera l'image 
int[] tableFreqRouge=TabFreq.Remplir(image).getRouge(); //dans un main pour avoir la table de frequence du rouge
MHuffman.Encoder(tableFreqRouge);
*/ 

public class MHuffman {

    public static Map<Integer, String> Encoder(int[] tf){ //prend en argument une table de frequence d'une couleur
        Noeud NoeudRacine = ArbreHuffman.construireArbre(tf); //ca donne un noeud
        Map<Integer, String> tabC = new HashMap<>(); //creation du tableau de codes sous forme de dico
        ParcoursArbre.dfsRecursive(NoeudRacine, "", tabC); //remplis le tableau de codes
        return tabC;
        //resultat : une table de code sous forme de dico
    }

}


