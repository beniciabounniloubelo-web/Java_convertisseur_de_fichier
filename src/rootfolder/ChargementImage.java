package rootfolder; 

import java.awt.image.BufferedImage;
import java.io.FileInputStream;
import java.io.IOException;

public class ChargementImage {
    
    private int largeur;
    private int hauteur;

    public ChargementImage(int largeur, int hauteur) {
        this.largeur = largeur;
        this.hauteur = hauteur;
    }

    public BufferedImage chargedImage(String imageavoir) {

        try (FileInputStream fis = new FileInputStream(imageavoir)) {
            byte[] rdb = fis.readAllBytes();
            BufferedImage image = new BufferedImage(largeur, hauteur, BufferedImage.TYPE_INT_RGB);

            int index = 0;
            for (int y = 0; y < hauteur; y++) {
                for (int x = 0; x < largeur; x++) {
                    int r = rdb[index++] & 0xFF;
                    int g = rdb[index++] & 0xFF;
                    int b = rdb[index++] & 0xFF;

                    int couleur = (r << 16) | (g << 8) | b;
                    image.setRGB(x, y, couleur);
                }
            }
        
        fis.close();
        return image;
        
        } catch (IOException e) {
            e.printStackTrace();
            return null;
        }

    }
}


