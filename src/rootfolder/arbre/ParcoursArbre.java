package arbre;

import java.util.Map;
import java.util.HashMap;

public class ParcoursArbre{

    //etape 3: parcours de l'arbre et creation de la table de code
    //methode iterative - DFS
    public static void dfsRecursive (Noeud NoeudActuel, String actualCode, Map<Integer, String> tabCode) {

        if (NoeudActuel.getGauche() == null && NoeudActuel.getDroit() == null){
            int valeur = NoeudActuel.getValeur();
            tabCode.put(valeur, actualCode); //ajoute le code trouve pour la valeur de la feuille
            return;
        }

        //on veut se deplacer sur l'enfant de gauche ET on recupere le code et on le complete
        dfsRecursive(NoeudActuel.getGauche(), actualCode + "0", tabCode);
    
        //on veut se deplacer sur l'enfant de droite ET on recupere le code et on le complete
        dfsRecursive(NoeudActuel.getDroit(), actualCode + "1", tabCode);

    }
}