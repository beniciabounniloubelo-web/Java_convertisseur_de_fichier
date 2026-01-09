package rootfolder.canonique;

public class TabCaEntree implements Comparable<TabCaEntree>{
            private int valeur; //valeur du pixel
            private int longeurCode; //longueur de son code

            TabCaEntree(int v, int lc) {
                this.valeur = v;
                this.longeurCode = lc;
            }

            // avec Comparable<T> sert a trier par longueur du code (- longueur du code, + haute priorité) 
            @Override
            public int compareTo(TabCaEntree autre) {
            return Integer.compare(this.longeurCode, autre.longeurCode); // on compare la frequence actuelle avec cette qui vient d'etre passee en parametre
            }

            public int getValeur(){
                return valeur;
            }
            public int getLongueurCode(){
                return longeurCode;
            }
}