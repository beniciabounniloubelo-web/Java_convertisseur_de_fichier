package rootfolder.frequence;

import javax.swing.*;

//gere affichage de la table de frequence
public class AfficherTabFreq {
    public static JScrollPane affichage(int[] tableFreq, String Couleur){

    String[] colonnes = {"Valeur", Couleur};
    Object[][] donnees = new Object[tableFreq.length][2];

    for (int i = 0; i < tableFreq.length; i++) {
        donnees[i][0] = i;
        donnees[i][1] = tableFreq[i];
    }

    JTable table = new JTable(donnees, colonnes);
    JScrollPane scroll = new JScrollPane(table);

    return scroll;
    }
}
