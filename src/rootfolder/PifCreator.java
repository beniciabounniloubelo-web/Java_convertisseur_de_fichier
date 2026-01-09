package rootfolder;

import java.awt.image.BufferedImage;
import java.io.DataOutputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Map;

import javax.swing.JOptionPane;

public class PifCreator {

    private BufferedImage img;
    private File fichier;
    private Map<Integer, String> tableCanoRouge;
    private Map<Integer, String> tableCanoVert;
    private Map<Integer, String> tableCanoBleu;

    // constructeur pour initialiser tout
    public PifCreator(BufferedImage img, File fichier, Map<Integer, String> tableCanoRouge, Map<Integer, String> tableCanoVert, Map<Integer, String> tableCanoBleu) {
        this.img = img;
        this.fichier = fichier;
        this.tableCanoRouge = tableCanoRouge;
        this.tableCanoVert = tableCanoVert;
        this.tableCanoBleu = tableCanoBleu;
    }

    public void ecrirePif() {
        try (DataOutputStream dos = new DataOutputStream(new FileOutputStream(fichier))) {

            // -------- EN TETE --------
            dos.writeShort(img.getWidth());
            dos.writeShort(img.getHeight());
            // -------- TABLES CANONIQUES --------
            TabCanoWriter writer1 = new TabCanoWriter();
            writer1.ecrireTableCanonique(dos, tableCanoRouge);
            writer1.ecrireTableCanonique(dos, tableCanoVert);
            writer1.ecrireTableCanonique(dos, tableCanoBleu);
            // -------- PIXELS --------
            PixelsWriter writer2 = new PixelsWriter();
            writer2.ecrirePixels(dos, img, tableCanoRouge, tableCanoVert, tableCanoBleu);

        } catch (IOException e) {
            e.printStackTrace();
        JOptionPane.showMessageDialog(null, "Le fichier a ete converti avec succes !");
        }
}
}
