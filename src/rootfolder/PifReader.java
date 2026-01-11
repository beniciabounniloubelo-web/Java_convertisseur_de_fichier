package rootfolder;

import javax.swing.JOptionPane;
import java.util.TreeMap;
import java.awt.Color;
import java.io.DataInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.Map;
import java.awt.image.BufferedImage;

/**
 * La classe PifReader permet de lire un fichier au format PIF et de reconstruire
 * l'image associee.
 * <p>
 * Cette classe lit les donnees binaires d'un fichier PIF, extrait les informations
 * d'en-tete, les tables de codes canoniques pour chaque composante de couleur,
 * puis decode les pixels pour reconstruire l'image.
 * </p>
 */
public class PifReader {

    /**
     * Image reconstruite a partir du fichier PIF.
     */
    private BufferedImage img;

    /**
     * Fichier PIF a lire.
     */
    private File fichier;

    /**
     * Largeur de l'image.
     */
    private int largeur;

    /**
     * Hauteur de l'image.
     */
    private int hauteur;

    /**
     * Construit un objet PifReader pour lire un fichier PIF.
     *
     * @param fichier le fichier PIF a lire
     */
    public PifReader(File fichier) {
        this.fichier = fichier;
    }

    /**
     * Lit le fichier PIF et reconstruit l'image.
     * <p>
     * Cette methode lit l'en-tete du fichier, les tables de codes canoniques pour chaque
     * composante de couleur, puis decode les donnees binaires des pixels pour reconstruire
     * l'image.
     * </p>
     *
     * @throws IOException si une erreur survient lors de la lecture du fichier
     */
    public void lirePif() throws IOException {
        // Message de debut
        JOptionPane.showMessageDialog(null, "Lecture lancee. Veuillez patienter...", "Information", JOptionPane.INFORMATION_MESSAGE);

        try (DataInputStream dis = new DataInputStream(new FileInputStream(fichier))) {

            // Lecture de l'en-tete
            largeur = dis.readUnsignedShort();
            hauteur = dis.readUnsignedShort();

            img = new BufferedImage(largeur, hauteur, BufferedImage.TYPE_INT_RGB);

            // Lecture des tables canoniques
            Map<Integer, Integer> dicoR = new TreeMap<>();
            Map<Integer, Integer> dicoV = new TreeMap<>();
            Map<Integer, Integer> dicoB = new TreeMap<>();

            for (int i = 0; i < 256; i++) dicoR.put(i, dis.readUnsignedByte());
            for (int i = 0; i < 256; i++) dicoV.put(i, dis.readUnsignedByte());
            for (int i = 0; i < 256; i++) dicoB.put(i, dis.readUnsignedByte());

            Map<String, Integer> tableCanoRouge = MCanoniqueBis.EncoderEncore(dicoR);
            Map<String, Integer> tableCanoVert = MCanoniqueBis.EncoderEncore(dicoV);
            Map<String, Integer> tableCanoBleu = MCanoniqueBis.EncoderEncore(dicoB);

            // Lecture des pixels
            StringBuilder fluxBinaire = new StringBuilder();
            while (dis.available() > 0) {
                int octet = dis.readUnsignedByte();
                fluxBinaire.append(
                    String.format("%8s", Integer.toBinaryString(octet)).replace(' ', '0')
                );
            }

            int indexBit = 0;

            for (int y = 0; y < hauteur; y++) {
                for (int x = 0; x < largeur; x++) {

                    Integer r = null, g = null, b = null;

                    String tamponR = "";
                    while (r == null && indexBit < fluxBinaire.length()) {
                        tamponR += fluxBinaire.charAt(indexBit++);
                        if (tableCanoRouge.containsKey(tamponR)) {
                            r = tableCanoRouge.get(tamponR);
                        }
                    }

                    String tamponV = "";
                    while (g == null && indexBit < fluxBinaire.length()) {
                        tamponV += fluxBinaire.charAt(indexBit++);
                        if (tableCanoVert.containsKey(tamponV)) {
                            g = tableCanoVert.get(tamponV);
                        }
                    }

                    String tamponB = "";
                    while (b == null && indexBit < fluxBinaire.length()) {
                        tamponB += fluxBinaire.charAt(indexBit++);
                        if (tableCanoBleu.containsKey(tamponB)) {
                            b = tableCanoBleu.get(tamponB);
                        }
                    }

                    if (r == null) r = 0;
                    if (g == null) g = 0;
                    if (b == null) b = 0;

                    img.setRGB(x, y, new Color(r, g, b).getRGB());
                }
            }
        }
    }

    /**
     * Retourne l'image reconstruite a partir du fichier PIF.
     *
     * @return l'image reconstruite
     */
    public BufferedImage getImage() {
        return img;
    }
}
