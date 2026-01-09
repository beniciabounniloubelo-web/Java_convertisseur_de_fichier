package rootfolder;

import java.io.DataOutputStream;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.util.Map;

public class PixelsWriter{

    public void ecrirePixels(DataOutputStream dos, BufferedImage image, Map<Integer, String> tableCanoRouge, Map<Integer, String> tableCanoVert, Map<Integer, String> tableCanoBleu) throws IOException{     
        int largeur=image.getWidth();
        int longueur=image.getHeight();
        int nbPixels=largeur*longueur;
        String[] pixel= new String[nbPixels];
        for (int i = 0; i < nbPixels; i++) { //initialisation du tableau
            pixel[i] = "";
        }
    
        for (int y = 0; y < longueur; y++) {
            for (int x = 0; x < largeur; x++) {
                int pixelRGB = image.getRGB(x, y);
                int r = (pixelRGB >> 16) & 0xFF;
                int v = (pixelRGB >> 8) & 0xFF;
                int b = pixelRGB & 0xFF;
        
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
        
                pixel[y*largeur+x] = codeR + codeV + codeB;
            }
        }
    
        //but: faire rentrer nos pixels dans des octets
        int tampon = 0;
        int SIZE = 0;
        
        for (int j = 0; j < nbPixels; j++) {
            // convertir la chaine binaire du pixel en int
            int pixelValue = Integer.parseInt(pixel[j], 2);
            int pixelSize = pixel[j].length();
        
            tampon = (tampon << pixelSize) | pixelValue;
            SIZE += pixelSize;
        
            // ecrire les octets complets
            while (SIZE >= 8) {
                int octet = (tampon >> (SIZE - 8)) & 0xFF;
                dos.writeByte(octet);
                SIZE -= 8;
                tampon = tampon & ((1 << SIZE) - 1); // garder les bits restants
            }
        }
        
        // ecrire le dernier octet si nécessaire
        if (SIZE > 0) {
            int dernierOctet = tampon << (8 - SIZE);
            dos.writeByte(dernierOctet);
        }
    }
}