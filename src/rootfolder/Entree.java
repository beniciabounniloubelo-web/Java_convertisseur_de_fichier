public class Entree implements Comparable<Noeud>{
            private int valeur; //Valeur du pixel
            private int longeurCode; //longueur de son code

            Entree(int v, long lc) { //c'est une feuille
                this.valeur = v;
                this.longeurCode = lc;
            }

            // avec Comparable<T> sert a trier par longueur du code (- longueur du code, + haute priorité) 
            @Override
            public int compareTo(Entree autre) {
            return Int.compare(this.longeurCode, autre.longeurCode); // on compare la frequence actuelle avec cette qui vient d'etre passee en parametre
            }

            public int getValeur(){
                return valeur;
            }
            public int getLongueurCode(){
                return longeurCode;
            }
}