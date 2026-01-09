package rootfolder.canonique;

import javax.swing.*;
import java.util.Map;

//gere affichage de la table de frequence
public class AfficherTabCa {
    public static JScrollPane affichage(Map<Integer, String>  tableCa, String Couleur){

    String[] colonnes = {"Valeur", Couleur};
    Object[][] donnees = new Object[tableCa.size()][2];

    int i=0;
    for (Map.Entry<Integer, String> entree : tableCa.entrySet()) {
        donnees[i][0] = entree.getKey();
        donnees[i][1] = entree.getValue();
        i++;
    }

    JTable table = new JTable(donnees, colonnes);
    JScrollPane scroll = new JScrollPane(table);

    return scroll;
    }
}