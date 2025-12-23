import java.util.Comparator;
import java.util.Map;
import java.util.PriorityQueue;


public class Noeud implements Comparable<Noeud>{
            private int valeur; // Valeur du pixel
            private long frequence; // = cb de fois apparait cette valeur pour une valeur donnee
            private Noeud gauche; //enfant de gauche
            private Noeud droit; //enfant de droite

            Noeud(int valeur, long frequence) { //c'est une feuille
                this.valeur = valeur;
                this.frequence = frequence;
                this.gauche = null;
                this.droit = null;
            }

            Noeud(long frequence, Noeud gauche, Noeud droit) { //c'est un noeud interne
                this.valeur = -1; //donc pas de pixel associe
                this.frequence = frequence;
                this.gauche = gauche;
                this.droit = droit;
            }

        
           // avec Comparable<T> sert a trier par frequence (- frequence, + haute priorité)
            @Override
            public int compareTo(Noeud autre) {
            return Long.compare(this.frequence, autre.frequence); // on compare la frequence actuelle avec cette qui vient d'etre passee en parametre
            }

            public long getFrequence(){
                return frequence;
            }
}


        