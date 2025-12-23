import java.util.Map;
import java.util.TreeMap;
import java.awt.image.*;
import java.awt.Color;

//BufferedImage img = ImageIO.read(new File "nomdelimage.pif"); //on charge l'image

public class TabFreq {

    public void Remplir(Tab tableau, BufferedImage img, int x, int y, String s){ //on rentre l'image, les dimensions de l'image + de quelle couleur on veut la table de frequence
        Map<Integer, Integer> tab = tableau.getTab();    //???

        for (int i=0; i<255; i++){ //pour les 256 valeurs
            int o=0; //represente le nombre de fois qu'apparait valeur i

            for (int L=0; L<x; L++){ //parcours en largeur de l'image
                for (int h=0; h<y; h++){ //parcours hauteur de l'image
                    int rgb = img.getRGB(L,h); //on recupere rgb d'un pixel
                    Color couleur=new Color(rgb); 
                    //il n'y a que l'objet Color qui pourra decoder le nb rgb et le traduire en couleur
                    
                    switch (s) {
                        case "r":
                            if (couleur.getRed() == i){ //on verifie si l'intensite de rouge correspond a la valeur actuelle
                            o++;
                            }
                            break;
                        case "g":
                            if (couleur.getGreen() == i){ //on verifie si l'intensite de vert correspond a la valeur actuelle
                            o++;
                            }
                            break;
                        case "b":
                            if (couleur.getBlue() == i){ //on verifie si l'intensite de bleu correspond a la valeur actuelle
                            o++;
                            }
                            break;
                        default:
                            System.out.println("Cette chaine de caractere n'est pas reconnue.");
                            break;
                    }
                }   
            }
        tab.put(i,o); //a la fin on ajoute la frequence au tableau de la couleur - ca nous donne une entree
        }
    }

}
