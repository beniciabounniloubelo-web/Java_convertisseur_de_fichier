import java.util.Map;
import java.util.TreeMap;
import java.awt.image.*;
import java.awt.Color;

//BufferedImage img = ImageIO.read(new File "nomdelimage.pif"); //on chargera l'image ds le Main
//comme dans Noeud
//on cree ici les 3 tables (qui vont etre return par la suite)

public class TabFreq {

    public int[][] Remplir(BufferedImage img){
        int[][] tableau = new int[255][3];

            for (int L=0; L<img.getWidth(); L++){ //parcours en largeur de l'image
                for (int h=0; h<img.getHeight(); h++){ //parcours hauteur de l'image
                    int rgb = img.getRGB(L,h); //on recupere rgb d'un pixel
                    Color couleur=new Color(rgb); 
                    //il n'y a que l'objet Color qui pourra decoder le nb rgb et le traduire en couleur
                    
                        tableau[couleur.getRed()][0]++; //on met a jour au fur et a mesure la frequence au tableau de la couleur
                        tableau[couleur.getGreen()][1]++;
                        tableau[couleur.getBlue()][2]++;

                }   
            }
    return tableau;
    }

}
