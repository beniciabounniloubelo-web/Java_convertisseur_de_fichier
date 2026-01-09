package rootfolder;

import rootfolder.frequence.*;
import rootfolder.canonique.*;
import rootfolder.arbre.*;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.awt.image.BufferedImage;
import java.util.Map;
import java.io.File;
import java.io.IOException;
import java.io.DataOutputStream;
import java.io.FileOutputStream;

public class PrintImage {

    public static void main(String[] args) {
            //on cree l'objet ChargementImage
            ChargementImage image = new ChargementImage();
            
            // on charge l'image
            BufferedImage img = null;
            if (args.length >= 1){
            img = image.chargedImageCompressee(args[0]); 
            } else {
                JFileChooser choose = new JFileChooser(new File("."));
                choose.setDialogTitle("Choisissez une image: ");
                int res = choose.showOpenDialog(null);
                if(res == JFileChooser.APPROVE_OPTION){
                    if(!choose.getSelectedFile().isDirectory()){
                        img = image.chargedImageCompressee(choose.getSelectedFile());
                    }
                }
            }
            BufferedImage imgbis = img;

            //on veut recuperer table de frequence pour chaque couleur
            int[] tableFreqRouge=TabFreq.RemplirTabFreq(img).getRouge();
            int[] tableFreqVert=TabFreq.RemplirTabFreq(img).getVert();
            int[] tableFreqBleu=TabFreq.RemplirTabFreq(img).getBleu();

            //on recupere table de codes pour chaque couleur
            Map<Integer, String> tableCodeRouge = MHuffman.Encoder(tableFreqRouge);
            Map<Integer, String> tableCodeVert = MHuffman.Encoder(tableFreqVert);
            Map<Integer, String> tableCodeBleu = MHuffman.Encoder(tableFreqBleu);

            //on recupere table canonique pour chaque couleur
            Map<Integer, String> tableCanoRouge = MCanonique.EncoderEncore(tableCodeRouge);
            Map<Integer, String> tableCanoVert = MCanonique.EncoderEncore(tableCodeVert);
            Map<Integer, String> tableCanoBleu = MCanonique.EncoderEncore(tableCodeBleu);

            // on cree une fenetre
            JFrame frame = new JFrame("Convertisseur");
            frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
 
            //onglet IMAGE---------------------------------------
            JLabel imageaafficher = new JLabel(new ImageIcon(img));
            JButton bouton = new JButton("Convertir");
            bouton.addActionListener(new ActionListener(){ //bouton pour convertir
                @Override
                public void actionPerformed(ActionEvent e){ //blablabla  pour convertir

                    ChoisirEtCreerPif choisir = new ChoisirEtCreerPif();
                    File newfichierpif = choisir.choisirEtCreerFichierPif(args, frame);
                    //on recupere nom du nv fichier--------------------------
                    if (newfichierpif != null) { //on rentre dans la conversion la !!
                    PifCreator pifFile= new PifCreator(imgbis, newfichierpif, tableCanoRouge, tableCanoVert, tableCanoBleu);
                    pifFile.ecrirePif();
                    }
                }
            });

            JPanel pourimage = new JPanel();
            pourimage.setLayout(new BorderLayout());
            pourimage.add(imageaafficher, BorderLayout.NORTH); //ajout de l'image dans le contenant 
            pourimage.add(bouton, BorderLayout.SOUTH); //un JListener de bouton

            //onglets autres---------------------------------------
            JPanel pourtabfreq=new JPanel(); //contenant des tables de frequence
            JPanel tabfreqrouge=new JPanel(); //contenant pour chacune de nos trois tables de frequence
            JPanel tabfreqvert=new JPanel();
            JPanel tabfreqbleu=new JPanel();

            tabfreqrouge.add(AfficherTabFreq.affichage(tableFreqRouge, "Rouge")); //pour tables frequence
            tabfreqvert.add(AfficherTabFreq.affichage(tableFreqVert, "Vert"));
            tabfreqbleu.add(AfficherTabFreq.affichage(tableFreqBleu, "Bleu"));
            //dans notre contenant pour les tables de frequences on met tout
            pourtabfreq.add(new JLabel("Tables de frequence de l'image")); //afficher titre de la partie
            pourtabfreq.add(tabfreqrouge); //on les ajoutes a la section/panel tab de freq
            pourtabfreq.add(tabfreqvert);
            pourtabfreq.add(tabfreqbleu);

            JPanel pourtabcode=new JPanel(); //pour tables code
            JPanel tabcoderouge=new JPanel();
            JPanel tabcodevert=new JPanel();
            JPanel tabcodebleu=new JPanel();

            tabcoderouge.add(AfficherTabCode.affichage(tableCodeRouge, "Rouge"));
            tabcoderouge.add(AfficherTabCode.affichage(tableCodeRouge, "Vert"));
            tabcoderouge.add(AfficherTabCode.affichage(tableCodeRouge, "Bleu"));
            pourtabcode.add(new JLabel("Tables de codes de l'image"));
            pourtabcode.add(tabcoderouge);
            pourtabcode.add(tabcodevert);
            pourtabcode.add(tabcodebleu);

            JPanel pourtabcanonique=new JPanel(); //pour tables cano
            JPanel tabcanorouge=new JPanel();
            JPanel tabcanovert=new JPanel();
            JPanel tabcanobleu=new JPanel();

            tabcanorouge.add(AfficherTabCa.affichage(tableCanoRouge, "Rouge"));
            tabcanorouge.add(AfficherTabCa.affichage(tableCanoRouge, "Vert"));
            tabcanorouge.add(AfficherTabCa.affichage(tableCanoRouge, "Bleu"));
            pourtabcanonique.add(new JLabel("Tables canoniques de l'image"));
            pourtabcanonique.add(tabcanorouge);
            pourtabcanonique.add(tabcanovert);
            pourtabcanonique.add(tabcanobleu);

            JTabbedPane onglets = new JTabbedPane(); //cree les onglets pour chacune des types de tables
            onglets.add("Image", pourimage);
            onglets.add("Frequences", pourtabfreq);
            onglets.add("Codes", pourtabcode);
            onglets.add("Canoniques", pourtabcanonique);

            frame.setLayout(new BorderLayout());
            frame.add(onglets);

            frame.pack(); // adapte la fenêtre au contenu
            frame.setLocationRelativeTo(null); // centre la fenêtre
            frame.setVisible(true);
    }
}


