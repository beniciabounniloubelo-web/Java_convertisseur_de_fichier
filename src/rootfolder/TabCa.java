



public class TabCa(){
    public static Queue<Entree> RemplirTabCanon(Map<Integer, String> tableCode){ //prend en argument une table de code

        //etape 1: creation de la file qui trie par longueur de code
        Queue<Entree> afile=new PriorityQueue<>(); //une file d'entree de la table de frequence
        
        for (tableCode.entrySet()) { //on cree une table canonique triee
            k = tableCode.getKey();
            v = tablecode.getValue().length();
            afile.add(new Entree(k,v));
        }

        return afile;
    }
}