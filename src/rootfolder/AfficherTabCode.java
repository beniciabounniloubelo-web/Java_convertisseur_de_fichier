package rootfolder;

import javax.swing.*;
import java.util.Map;

/**
 * La classe AfficherTabCode gere l'affichage d'une table de codes sous forme de tableau graphique.
 * <p>
 * Cette classe permet de visualiser les valeurs et leurs codes associes (par exemple, les codes de Huffman)
 * dans une interface graphique a l'aide d'un JTable integre dans un JScrollPane.
 * </p>
 */
public class AfficherTabCode {

    /**
     * Cree et retourne un JScrollPane contenant un tableau graphique (JTable) affichant les valeurs
     * et leurs codes associes.
     *
     * @param tableCo une map associant chaque valeur a son code (par exemple, les codes de Huffman)
     * @param couleur le nom de la colonne representant les codes (par exemple, "Code Huffman")
     * @return un JScrollPane contenant le tableau graphique des valeurs et de leurs codes
     */
    public static JScrollPane affichage(Map<Integer, String> tableCo, String couleur) {

        String[] colonnes = {"Valeur", couleur};
        Object[][] donnees = new Object[tableCo.size()][2];

        int i = 0;
        for (Map.Entry<Integer, String> entree : tableCo.entrySet()) {
            donnees[i][0] = entree.getKey();
            donnees[i][1] = entree.getValue();
            i++;
        }

        JTable table = new JTable(donnees, colonnes);
        JScrollPane scroll = new JScrollPane(table);

        return scroll;
    }
}
