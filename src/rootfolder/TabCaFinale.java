
//creation de la table canonique finale
public class TabCaFinale {
    public static void createTabCaFinale(String code, Queue<Entree> afile, Map<Integer, String> tabCanonique){

            if (afile.isEmpty()) { //la fonction tourne jusqu'a la file soit vide - condition d'arret
                return;
            }

            Entree e1 = afile.poll(); //on a une entree
            String newcode = code; //on recupere le code
            while (newcode.length() < e1.getLongueurCode) { //comparaison
            newcode = newcode + "0"; //on donne au code la longueur souhaite
            }

            if (newcode.length() == e1.getLongueurCode){ //si code a la bonne longueur
                tabCanonique.put(e1.getValeur(), newcode); //ajout dans le dico
            }

            //on cree le code pour la prochaine valeur
            int a = Integer.parseInt(code, 2); // on transforme le code qui est un string en int
            a++; //on l'incremente
            String nextcode = Integer.toBinaryString(a); //on le repasse en string

            createTabCaFinale(nextcode, afile, tableCode);
    }
}