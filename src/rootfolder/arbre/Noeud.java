package arbre;

import java.lang.Comparable;
import java.util.Map;
import java.util.PriorityQueue;

/**La classe Noeud represente le noeud d'un arbre binaire de Huffman.
 * <p>
 * Un noeud peut etre: une feuille ou un noeud interne.
 * </p>
 * <p>
 * Cette classe implemente l’interface {@link Comparable} afin de permettre
 * le tri des nœuds par frequence, notamment lors de la construction de l’arbre
 * à l’aide d’une file de priorite.
 * </p>
 */
public class Noeud implements Comparable<Noeud>{

            /**
             * Valeur associee a un noeud
             */
            private int valeur; // Valeur du pixel

            /**
             * Frequence d'apparation de cette valeur
             */
            private long frequence; // = cb de fois apparait cette valeur pour une valeur donnee

            /**
             * Reference vers le fils gauche du noeud
             */
            private Noeud gauche; //enfant de gauche

            /**
             * Reference vers le fils droit du noeud
             */
            private Noeud droit; //enfant de droite

            /**Construis un noeud feuille
             * 
             * @param v la valeur de la feuille
             * @param f la frequence de la feuille
             */
            Noeud(int v, long f) { //c'est une feuille
                this.valeur = v;
                this.frequence = f;
                this.gauche = null;
                this.droit = null;
            }

            /**Construis un noeud interne
             * 
             * @param f la frequence du noeud
             * @param g le fils gauche du noeud
             * @param d le fils droit du noeud
             */
            Noeud(long f, Noeud g, Noeud d) { //c'est un noeud interne
                this.valeur = -1; //donc pas de pixel associe
                this.frequence = f;
                this.gauche = g;
                this.droit = d;
            }


            /**Compare deux noeuds en fonction de leur frequence (- frequence, + haute priorite)
             * <p>
             * Cette methode sert a ordonner les noeuds dans une file lors de la construction de l'arbre binaire de Huffman
             * </p>
             * 
             * @param autre le noeud a comparer
             * @return une valeur negative, nulle ou positive selon que la frequence de ce nœud est inferieure, 
             * egale ou superieure à celle du nœud compare
            */
            @Override // avec Comparable<T> sert a trier par frequence (- frequence, + haute priorite)
            public int compareTo(Noeud autre) {
            return Long.compare(this.frequence, autre.frequence); // on compare la frequence actuelle avec cette qui vient d'etre passee en parametre
            }

            /**
             * Renvoie la frequence du nœud
             * 
             * @return la frequence du noeud
             */
            public long getFrequence(){
                return frequence;
            }

            /**
             * Renvoie la valeur du nœud
             * 
             * @return la valeur du noeud
             */
            public int getValeur(){
                return valeur;
            }

            /**
             * Renvoie le fils gauche du nœud
             * 
             * @return le fils gauche du noeud
             */
            public Noeud getGauche(){
                return gauche;
            }

            /**
             * Renvoie le fils droit du nœud
             * 
             * @return le fils droit du noeud
             */
            public Noeud getDroit(){
                return droit;
            }
}


        