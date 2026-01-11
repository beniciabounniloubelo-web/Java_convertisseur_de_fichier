package rootfolder;

import javax.swing.*;

//gere affichage de la table de frequence

/**
 * La classe AfficherTabFreq gere l'affichage d'un tableau de frequences sous forme de tableau graphique.
 * <p>
 * Cette classe permet de visualiser les valeurs et leurs frequences associees
 * dans une interface graphique a l'aide d'un JTable integre dans un JScrollPane.
 * </p>
 */
public class AfficherTabFreq {

    /**
     * Cree et retourne un JScrollPane contenant un tableau graphique (JTable) affichant les valeurs
     * et leurs frequences associees.
     *
     * @param tableFreq un tableau de frequences ou chaque indice represent une valeur
     *                  et la valeur a cet indice represent sa frequence d'apparition
     * @param couleur le nom de la colonne representant les frequences (par exemple, "Frequence Rouge")
     * @return un JScrollPane contenant le tableau graphique des valeurs et de leurs frequences
     */
    public static JScrollPane affichage(int[] tableFreq, String couleur) {

        String[] colonnes = {"Valeur", couleur};
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
