package rootfolder;

import java.io.File;
import java.io.IOException;
import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JOptionPane;

/**
 * La classe ChoisirEtCreerPif permet de choisir et de creer un fichier avec l'extension .pif.
 * <p>
 * Cette classe fournit une methode pour selectionner un emplacement et un nom de fichier,
 * soit a partir des arguments passes en ligne de commande, soit via une interface graphique.
 * Si le fichier n'existe pas, il est cree automatiquement avec l'extension .pif.
 * </p>
 */
public class ChoisirEtCreerPif {

    /**
     * Choisit et cree un fichier avec l'extension .pif.
     * <p>
     * Si un chemin de fichier est fourni dans les arguments de la ligne de commande,
     * ce chemin est utilise. Sinon, une boite de dialogue s'ouvre pour permettre
     * a l'utilisateur de choisir l'emplacement et le nom du fichier.
     * Si le fichier n'a pas l'extension .pif, celle-ci est ajoutee automatiquement.
     * </p>
     *
     * @param args les arguments passes en ligne de commande
     * @param frame la fenetre parente pour afficher la boite de dialogue de sauvegarde
     * @return le fichier cree ou selectionne avec l'extension .pif,
     *         ou null si l'utilisateur annule loperation ou si une erreur survient
     */
    public File choisirEtCreerFichierPif(String[] args, JFrame frame) {
        File newfichierpif = null;

        // On recupere le nom du nouveau fichier
        if (args.length >= 2) {
            newfichierpif = new File(args[1]);
            // Ajouter l'extension .pif si necessaire
            if (!newfichierpif.getName().endsWith(".pif")) {
                newfichierpif = new File(newfichierpif.getAbsolutePath() + ".pif");
            }
        }

        if (newfichierpif == null) {
            JFileChooser choose = new JFileChooser(new File("."));
            choose.setDialogTitle("Choisissez l'emplacement du fichier .pif");
            int res = choose.showSaveDialog(frame);
            if (res == JFileChooser.APPROVE_OPTION) {
                newfichierpif = choose.getSelectedFile();
                if (!newfichierpif.getName().endsWith(".pif")) {
                    newfichierpif = new File(newfichierpif.getAbsolutePath() + ".pif");
                }
            } else {
                return null;
            }
        }

        // Creation du fichier
        try {
            if (!newfichierpif.exists()) {
                newfichierpif.createNewFile();
            }
        } catch (IOException exc) {
            exc.printStackTrace();
            return null;
        }

        return newfichierpif;
    }
}
