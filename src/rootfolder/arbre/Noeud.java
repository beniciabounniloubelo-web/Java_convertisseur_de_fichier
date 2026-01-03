package rootfolder.arbre;

import java.lang.Comparable;
import java.util.Map;
import java.util.PriorityQueue;

public class Noeud implements Comparable<Noeud>{
            private int valeur; // Valeur du pixel
            private long frequence; // = cb de fois apparait cette valeur pour une valeur donnee
            private Noeud gauche; //enfant de gauche
            private Noeud droit; //enfant de droite

            Noeud(int v, long f) { //c'est une feuille
                this.valeur = v;
                this.frequence = f;
                this.gauche = null;
                this.droit = null;
            }

            Noeud(long f, Noeud g, Noeud d) { //c'est un noeud interne
                this.valeur = -1; //donc pas de pixel associe
                this.frequence = f;
                this.gauche = g;
                this.droit = d;
            }


            // avec Comparable<T> sert a trier par frequence (- frequence, + haute priorité)
            @Override
            public int compareTo(Noeud autre) {
            return Long.compare(this.frequence, autre.frequence); // on compare la frequence actuelle avec cette qui vient d'etre passee en parametre
            }

            public long getFrequence(){
                return frequence;
            }

            public int getValeur(){
                return valeur;
            }

            public Noeud getGauche(){
                return gauche;
            }

            public Noeud getDroit(){
                return droit;
            }
}


        