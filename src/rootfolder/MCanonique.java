public class MCanonique {

    public static Map<Integer, String> EncoderEncore(Map<Integer, String> tabCo){ //prend en argument une table de code d'une couleur

        Queue<Entree> fileTabCo = TabCa.RemplirTabCanon(tabCo);
        //creation d'un dico
        Map<Integer, String> tabCanon= new TreeMap<>(); //la cle etant les valeurs, le tri des valeurs est automatique car Treemap 
        // DONC permet une table canonique triee par longueur de code puis valeur
        TabCaFinale.createTabCaFinale("0", fileTabCo, tabCanon);
        return tabCanonique; 
        //resultat: une table canonique d'une couleur

    }

}