package rootfolder; //indique le chemin de cette classe

import rootfolder.arbre.*; //car on utilise ce qu'il y a cet endroit

import java.lang.Comparable;
import java.util.Queue;
import java.util.PriorityQueue;
import java.util.Map;
import java.util.HashMap;

/* Dans un Main
BufferedImage img = ImageIO.read(new File "nomdelimage.pif"); //on chargera l'image 
int[] tableFreqRouge=TabFreq.RemplirTabFreq(image).getRouge(); //dans un main pour avoir la table de frequence du rouge
MHuffman.Encoder(tableFreqRouge); //prend une table de frequence et donne une table de code - le tt pour une couleur
MCanonique.EncoderEncore(MHuffman.Encoder(tableFreqRouge)); //prend une table code et donne une table canonique - le tt pour une couleur
*/ 

public class MHuffman {

    public static Map<Integer, String> Encoder(int[] tf){ //prend en argument une table de frequence d'une couleur
        Noeud NoeudRacine = ArbreHuffman.construireArbre(tf); //ca donne un noeud
        Map<Integer, String> tabCo = new HashMap<>(); //creation du tableau de codes sous forme de dico
        ParcoursArbre.dfsRecursive(NoeudRacine, "", tabCo); //remplis le tableau de codes
        return tabCo;
        //resultat : une table de code sous forme de dico
    }

}


