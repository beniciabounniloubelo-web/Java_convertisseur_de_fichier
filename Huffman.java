import java.lang.Comparable;
import java.util.Set;
import java.util.Queue;
import java.util.Deque;
import java.util.ArrayDeque;
import java.util.PriorityQueue;
import java.util.Map;

//on fait couleur par couleur ?? cf.l15

public class Huffman {

    public void Codage (TabFreq tf, char c){

        //etape 1: creation de la file
        Queue<Noeud> unefile=new PriorityQueue<>(); //une file de noeuds
        
        if (c == 'r'){
        for (int i=0; i<256; i++){ //uniquement pour rouge là...??
            if (tf[i][0]>0){
                unefile.add(new Noeud (i, tf[i][0]);); //pour chaque entree on va creer une feuille que l'on place dans la file
            } 
        }
        }
        if (c == 'g'){
        for (int i=0; i<256; i++){ //uniquement pour vert
            if (tf[i][1]>0){
                unefile.add(new Noeud (i, tf[i][1]);); //pour chaque entree on va creer une feuille que l'on place dans la file
            } 
        }
        }
        if (c == 'b'){
        for (int i=0; i<256; i++){ //uniquement pour bleu
            if (tf[i][2]>0){
                unefile.add(new Noeud (i, tf[i][2]);); //pour chaque entree on va creer une feuille que l'on place dans la file
            } 
        }
        }

        //etape 2: creation de l'arbre
        //ca c'est ok
        while (unefile.size()>1){ //il doit y avoir au moins 2 elements ds la file
            Noeud e1 = unefile.remove(); //variables qui recupere les 2 premiers noeuds de la file (celles avec la frequence la plus faible)
            Noeud e2 = unefile.remove();
            long newfrq = e1.getFrequence() + e2.getFrequence();
            Noeud node=new Noeud(newfrq, e1, e2);
            unefile.add(node);
        }
        //a la fin de l'etape arbre = racine

        //etape 3: parcours de l'arbre et creation de la table de code cf. Parcours
        //ca c'est ok
        //methode iterative - DFS

    //general - creation d'une pile de Noeud pk cette forme ??
    Deque<Noeud> unePile = new ArrayDeque<>();
    //general - creation d'un code pour chaque valeur de la pile de Noeud (c'est sous la forme d'une pile) pk cette forme ??
    Deque<List<Integer>> unePileCode = new ArrayDeque<>();

    //creation du tableau de codes sous forme ??
    List<List<Integer>> tabCodes = new ArrayList<>();

    //pour pouvoir ensuite remplir le tableau de codes (soit faire un tabCodes.set)
    for (int i = 0; i < 256; i++) {
    tabCodes.add(null);
    }
    //on recupere la racine dans une pile
    unePile.push(unefile.remove());
    unePileCode.push(new ArrayList<>());

    Noeud NoeudActuel;
    while(!unePile.isEmpty()) {
        NoeudActuel = unePile.pop();
        List<Integer> actualCode = unePileCode.pop(); //creation du code actuel d'un noeud

        if(NoeudActuel.getDroit() != null) {
            //on recupere le code
            List<Integer> newcodeD = new ArrayList<>(actualcode);
            //on ajoute a l'arraylist
            newcodeD.add(1);
            //on veut se deplaceer sur l'enfant de droit
            unePile.push(NoeudActuel.getDroit());
            unePileCodes.push(newcodeD);
        }

        if(NoeudActuel.getGauche() != null) {
            //on recupere le code actuel
            List<Integer> newcodeG = new ArrayList<>(actualCode);
            //on etend le code
            newcodeG.add(0);
            //on veut se deplacer sur l'enfant de gauche
            unePile.push(NoeudActuel.getGauche());
            unePileCode.push(newcodeG);
        }

        if (NoeudActuel.getGauche() == null && NoeudActuel.getDroit() == null){
        int valeur = NoeudActuel.getValeur();
        tabCodes.set(valeur, actualCode) //ajoute le code trouve pour la valeur de la feuille
        }
    }
    return list; //retourne la table de codes
    }

/*Note:
1. construction de l’arbre avec une file
2. MAIS file n'est pas l’arbre
3. file ne sert qu’à manipuler/construire/parcourir l’arbre mais c'est les liens entre les noeuds qui SONT l'arbre
*/
}


