package rootfolder;

import java.awt.image.BufferedImage;
import java.io.File;
import java.io.FileInputStream; 
import java.io.IOException;
import javax.imageio.ImageIO;

public class ChargementImage {

    public BufferedImage chargedImageCompressee(String imageacharger) {
        try {
            BufferedImage imageachargerbis = ImageIO.read(new File(imageacharger));

            int largeur = imageachargerbis.getWidth();
            int hauteur = imageachargerbis.getHeight();

            BufferedImage image = new BufferedImage(largeur, hauteur, BufferedImage.TYPE_INT_RGB);

            for (int y = 0; y < hauteur; y++) {
                for (int x = 0; x < largeur; x++) {
                    int rgb = imageachargerbis.getRGB(x, y);

                    int r = (rgb >> 16) & 0xFF; //les 8 bits de poids forts
                    int g = (rgb >> 8) & 0xFF; //les 8 du milieu
                    int b = rgb & 0xFF; //les 8 bits de poids faibles

                    int couleur = (r << 16) | (g << 8) | b;
                    image.setRGB(x, y, couleur);
                }
            }
            return image;

        } catch (IOException e) {
            e.printStackTrace();
            return null;
        }
    }

    public BufferedImage chargedImageCompressee(File imageacharger) {
        try {
            BufferedImage imageachargerbis = ImageIO.read(imageacharger);

            int largeurbis = imageachargerbis.getWidth();
            int hauteurbis = imageachargerbis.getHeight();

            BufferedImage image = new BufferedImage(largeurbis, hauteurbis, BufferedImage.TYPE_INT_RGB);

            for (int y = 0; y < hauteurbis; y++) {
                for (int x = 0; x < largeurbis; x++) {
                    int rgb = imageachargerbis.getRGB(x, y);

                    int r = (rgb >> 16) & 0xFF; //les 8 bits de poids forts
                    int g = (rgb >> 8) & 0xFF; //les 8 du milieu
                    int b = rgb & 0xFF; //les 8 bits de poids faibles

                    int couleur = (r << 16) | (g << 8) | b;
                    image.setRGB(x, y, couleur);
                }
            }
            return image;

        } catch (IOException e) {
            e.printStackTrace();
            return null;
        }
    }
}
