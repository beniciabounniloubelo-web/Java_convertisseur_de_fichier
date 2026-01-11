package rootfolder;

import javax.swing.*;
import java.util.Map;

//gere affichage de la table de frequence


/**
 * La classe AfficherTabCa gere l'affichage d'une table de codes canoniques sous forme de tableau graphique.
 * <p>
 * Cette classe permet de visualiser les valeurs et leurs codes canoniques associes
 * dans une interface graphique a l'aide d'un JTable integre dans un JScrollPane.
 * </p>
 */
public class AfficherTabCa {

    /**
     * Cree et retourne un JScrollPane contenant un tableau graphique (JTable) affichant les valeurs
     * et leurs codes canoniques associes.
     *
     * @param tableCa une map associant chaque valeur a son code canonique
     * @param couleur le nom de la colonne representant les codes canoniques
     * @return un JScrollPane contenant le tableau graphique des valeurs et de leurs codes canoniques
     */
    public static JScrollPane affichage(Map<Integer, String> tableCa, String couleur) {

        String[] colonnes = {"Valeur", couleur};
        Object[][] donnees = new Object[tableCa.size()][2];

        int i = 0;
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
