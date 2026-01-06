package rootfolder;

import frequence.*;

import javax.swing.*;
import java.awt.*;
import java.awt.image.BufferedImage;

/* Dans un Main
BufferedImage img = ImageIO.read(new File "nomdelimage.pif"); //on chargera l'image 
int[] tableFreqRouge=TabFreq.RemplirTabFreq(image).getRouge(); //dans un main pour avoir la table de frequence du rouge
MHuffman.Encoder(tableFreqRouge); //prend une table de frequence et donne une table de code - le tt pour une seule couleur
MCanonique.EncoderEncore(MHuffman.Encoder(tableFreqRouge)); //prend une table code et donne une table canonique - le tt pour une couleur
*/

public class PrintImage {

    public static void main(String[] args) {
            //on cree l'objet ChargementImage
            ChargementImage exo = new ChargementImage(768, 1024); 
            // on charge l'image
            BufferedImage img = exo.chargedImage("image.bin");

            //on cree sa table de frequence
            //TroisCouleurs tc = TabFreq.RemplirTabFreq(img);

            //on veut recuperer table de frequence pour chaque couleur
            int[] tableFreqRouge=TabFreq.RemplirTabFreq(img).getRouge();
            int[] tableFreqVert=TabFreq.RemplirTabFreq(img).getVert();
            int[] tableFreqBleu=TabFreq.RemplirTabFreq(img).getBleu();

            //on recupere table de codes pour chaque couleur
            MHuffman.Encoder(tableFreqRouge);
            MHuffman.Encoder(tableFreqVert);
            MHuffman.Encoder(tableFreqBleu);

            //on recupere table canonique pour chaque couleur
            MCanonique.EncoderEncore(MHuffman.Encoder(tableFreqRouge));
            MCanonique.EncoderEncore(MHuffman.Encoder(tableFreqVert));
            MCanonique.EncoderEncore(MHuffman.Encoder(tableFreqBleu));

            // on cree une fenetre
            JFrame frame = new JFrame("on affiche !");
            frame.setSize(img.getWidth(), img.getHeight()); 
            frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

            // on ajoute JLabel a la fenetre
            JLabel label = new JLabel(new ImageIcon(img));
            frame.add(label);
            frame.pack(); // ajuste la fenetre a la taille de l'image
            //frame.setLocationRelativeTo(null);    // centre la fenetre au milieu de lecran

            frame.setVisible(true);

    }
}


