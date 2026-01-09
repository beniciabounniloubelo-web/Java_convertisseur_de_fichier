package rootfolder;

import java.io.File;
import java.io.IOException;
import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JOptionPane;

public class ChoisirEtCreerPif {

    public File choisirEtCreerFichierPif(String[] args, JFrame frame) {
        File newfichierpif = null;
    
        //on recupere nom du nv fichier--------------------------
        if (args.length >= 2){
            newfichierpif = new File(args[1]);
            // Ajouter l'extension .pif au besoin
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
                JOptionPane.showMessageDialog(frame, "Aucun fichier de sortie choisi");
                return null;
            }
        }
    
        //creation du fichier-------------------------
        try {
            if (!newfichierpif.exists()) {
                newfichierpif.createNewFile();
                JOptionPane.showMessageDialog(frame, "Fichier cree avec succes !");
            } else {
                JOptionPane.showMessageDialog(frame, "Le fichier existe deja");
            }
        } catch (IOException exc) {
            exc.printStackTrace();
            JOptionPane.showMessageDialog(null, "Erreur lors de la creation du fichier !");
            return null;
        }
        
        return newfichierpif;
    }
}