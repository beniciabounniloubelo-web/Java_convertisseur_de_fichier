package rootfolder.frequence;

import java.util.Map;
import java.util.TreeMap;
import java.awt.image.*;
import java.awt.Color;

//on cree ici les 3 tables (qui vont etre return par la suite)

public class TabFreq {

    public static TroisCouleurs RemplirTabFreq(BufferedImage img){
        int[] tableau1 = new int[256]; //rouge
        int[] tableau2 = new int[256]; //vert
        int[] tableau3 = new int[256]; //bleu

        for (int L=0; L<img.getWidth(); L++){ //parcours en largeur de l'image
            for (int h=0; h<img.getHeight(); h++){ //parcours hauteur de l'image
                int rgb = img.getRGB(L,h); //on recupere rgb d'un pixel
                Color couleur=new Color(rgb); 
                //il n'y a que l'objet Color qui pourra decoder le nb rgb et le traduire en couleur
                    
                tableau1[couleur.getRed()]++; //on met a jour au fur et a mesure la frequence ds le tableau de rouge
                tableau2[couleur.getGreen()]++;
                tableau3[couleur.getBlue()]++;
            }   
        }

        return new TroisCouleurs(tableau1,tableau2,tableau3);
    }

}
