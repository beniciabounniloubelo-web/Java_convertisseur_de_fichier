package rootfolder;

import javax.swing.JOptionPane;
import java.io.File;
import java.io.DataOutputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.awt.image.BufferedImage;
import java.util.Map;

public class PifCreator {

    /**
     * Image a convertir au format PIF.
     */
    private BufferedImage img;

    /**
     * Fichier de sortie pour stocker les donnees au format PIF.
     */
    private File fichier;

    /**
     * Table de codes canoniques pour la composante rouge.
     */
    private Map<Integer, String> tableCanoRouge;

    /**
     * Table de codes canoniques pour la composante verte.
     */
    private Map<Integer, String> tableCanoVert;

    /**
     * Table de codes canoniques pour la composante bleue.
     */
    private Map<Integer, String> tableCanoBleu;

    /**
     * Construit un objet PifCreator pour initialiser les parametres necessaires
     * a la creation d'un fichier PIF.
     *
     * @param img l'image a convertir
     * @param fichier le fichier de sortie
     * @param tableCanoRouge la table de codes canoniques pour la composante rouge
     * @param tableCanoVert la table de codes canoniques pour la composante verte
     * @param tableCanoBleu la table de codes canoniques pour la composante bleue
     */
    public PifCreator(BufferedImage img, File fichier, Map<Integer, String> tableCanoRouge,
                      Map<Integer, String> tableCanoVert, Map<Integer, String> tableCanoBleu) {
        this.img = img;
        this.fichier = fichier;
        this.tableCanoRouge = tableCanoRouge;
        this.tableCanoVert = tableCanoVert;
        this.tableCanoBleu = tableCanoBleu;
    }

    /**
     * Ecrit les donnees de l'image et des tables de codes canoniques dans un fichier PIF.
     *
     * Cette methode ecrit l'en-tete du fichier (largeur et hauteur de l'image),
     * les tables de codes canoniques pour chaque composante de couleur,
     * puis les donnees des pixels encodees.
     */
    public void ecrirePif() {
        // Enlever l'extension manuellement
        String cheminFichier = fichier.getAbsolutePath();
        int dernierPoint = cheminFichier.lastIndexOf('.');
        String nomFichierSortie;
        if (dernierPoint > 0) {
            nomFichierSortie = cheminFichier.substring(0, dernierPoint) + ".pif";
        } else {
            nomFichierSortie = cheminFichier + ".pif"; // Cas ou il n'y a pas d'extension
        }
        File fichierSortie = new File(nomFichierSortie);

        // Message de debut
        JOptionPane.showMessageDialog(null, "Conversion lancee. Veuillez patienter...", "Information", JOptionPane.INFORMATION_MESSAGE);

        try (DataOutputStream dos = new DataOutputStream(new FileOutputStream(fichierSortie))) {
            // Ecriture de l'en-tete
            dos.writeShort(img.getWidth());
            dos.writeShort(img.getHeight());

            // Ecriture des tables canoniques
            TabCanoWriter writer1 = new TabCanoWriter();
            writer1.ecrireTableCanonique(dos, tableCanoRouge);
            writer1.ecrireTableCanonique(dos, tableCanoVert);
            writer1.ecrireTableCanonique(dos, tableCanoBleu);

            // Ecriture des pixels
            PixelsWriter writer2 = new PixelsWriter();
            writer2.ecrirePixels(dos, img, tableCanoRouge, tableCanoVert, tableCanoBleu);

            // Message de fin
            JOptionPane.showMessageDialog(null, "Conversion terminee avec succes !\nFichier : " + fichierSortie.getName(), "Succes", JOptionPane.INFORMATION_MESSAGE);
        } catch (IOException e) {
            // Message d'erreur
            JOptionPane.showMessageDialog(null, "Erreur lors de la conversion : " + e.getMessage(), "Erreur", JOptionPane.ERROR_MESSAGE);
            e.printStackTrace();
        }
    }
}
