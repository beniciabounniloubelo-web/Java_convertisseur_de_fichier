package rootfolder;

import java.io.DataOutputStream;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.util.Map;

/**
 * La classe PixelsWriter permet d'ecrire les donnees des pixels d'une image
 * dans un flux de sortie en utilisant des tables de codes canoniques.
 * <p>
 * Cette classe convertit chaque pixel de l'image en une sequence binaire
 * basee sur les codes canoniques des composantes rouge, vert et bleu,
 * puis ecrit ces sequences dans un flux de sortie sous forme d'octets.
 * </p>
 */
public class PixelsWriter {

    /**
     * Ecrit les pixels d'une image dans un flux de sortie en utilisant les tables de codes canoniques.
     * <p>
     * Chaque pixel est converti en une sequence binaire composee des codes canoniques
     * de ses composantes rouge, vert et bleu. Ces sequences sont ensuite regroupees
     * en octets et ecrites dans le flux de sortie.
     * </p>
     *
     * @param dos le flux de sortie ou les donnees des pixels seront ecrites
     * @param image l'image dont les pixels doivent etre ecrits
     * @param tableCanoRouge la table de codes canoniques pour la composante rouge
     * @param tableCanoVert la table de codes canoniques pour la composante verte
     * @param tableCanoBleu la table de codes canoniques pour la composante bleue
     * @throws IOException si une erreur survient lors de l'ecriture dans le flux
     */
    public void ecrirePixels(DataOutputStream dos, BufferedImage image,
            Map<Integer, String> tableCanoRouge, Map<Integer, String> tableCanoVert,
            Map<Integer, String> tableCanoBleu) throws IOException {

        int largeur = image.getWidth();
        int longueur = image.getHeight();
        int nbPixels = largeur * longueur;
        String[] pixel = new String[nbPixels];

        // Initialisation du tableau de pixels
        for (int i = 0; i < nbPixels; i++) {
            pixel[i] = "";
        }

        // Conversion de chaque pixel en une sequence binaire
        for (int y = 0; y < longueur; y++) {
            for (int x = 0; x < largeur; x++) {
                int pixelRGB = image.getRGB(x, y);
                int r = (pixelRGB >> 16) & 0xFF;
                int v = (pixelRGB >> 8) & 0xFF;
                int b = pixelRGB & 0xFF;

                // Recherche des codes canoniques pour chaque composante
                String codeR = "0";
                for (Map.Entry<Integer, String> e : tableCanoRouge.entrySet()) {
                    if (e.getKey() == r) {
                        codeR = e.getValue();
                        break;
                    }
                }

                String codeV = "0";
                for (Map.Entry<Integer, String> e : tableCanoVert.entrySet()) {
                    if (e.getKey() == v) {
                        codeV = e.getValue();
                        break;
                    }
                }

                String codeB = "0";
                for (Map.Entry<Integer, String> e : tableCanoBleu.entrySet()) {
                    if (e.getKey() == b) {
                        codeB = e.getValue();
                        break;
                    }
                }

                pixel[y * largeur + x] = codeR + codeV + codeB;
            }
        }

        // Ecriture des sequences binaires dans le flux sous forme d'octets
        int tampon = 0;
        int SIZE = 0;

        for (int j = 0; j < nbPixels; j++) {
            String bitsPixel = pixel[j];

            for (int k = 0; k < bitsPixel.length(); k++) {
                int bit = bitsPixel.charAt(k) == '1' ? 1 : 0;

                tampon = (tampon << 1) | bit;
                SIZE++;

                if (SIZE == 8) {
                    dos.writeByte(tampon);
                    tampon = 0;
                    SIZE = 0;
                }
            }
        }

        // Ecriture du dernier octet si necessaire
        if (SIZE > 0) {
            int dernierOctet = tampon << (8 - SIZE);
            dos.writeByte(dernierOctet);
        }
    }
}
