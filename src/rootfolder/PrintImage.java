package rootfolder;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.awt.image.BufferedImage;
import java.util.Map;
import java.io.File;
import java.io.IOException;
import java.io.DataOutputStream;
import java.io.FileOutputStream;

/**
 * La classe PrintImage permet de charger une image, d'afficher ses tables de frequences,
 * ses tables de codes de Huffman et ses tables canoniques, puis de la convertir au format PIF.
 * <p>
 * Cette classe cree une interface graphique avec des onglets pour visualiser l'image,
 * les tables de frequences, les tables de codes de Huffman et les tables canoniques.
 * Elle permet egalement de convertir l'image en un fichier PIF via un bouton.
 * </p>
 */
public class PrintImage {

    /**
     * Redimensionne une image tout en conservant ses proportions.
     *
     * @param img l'image a redimensionner
     * @param maxWidth la largeur maximale souhaitee
     * @param maxHeight la hauteur maximale souhaitee
     * @return une instance de ImageIcon representant l'image redimensionnee
     */
    private static ImageIcon redimensionnerImage(BufferedImage img, int maxWidth, int maxHeight) {
        int imgWidth = img.getWidth();
        int imgHeight = img.getHeight();

        // Calculer les nouvelles dimensions en gardant les proportions
        double ratio = Math.min((double) maxWidth / imgWidth, (double) maxHeight / imgHeight);
        int newWidth = (int) (imgWidth * ratio);
        int newHeight = (int) (imgHeight * ratio);

        // Redimensionner l'image
        Image scaledImage = img.getScaledInstance(newWidth, newHeight, Image.SCALE_SMOOTH);
        return new ImageIcon(scaledImage);
    }

    /**
     * Methode principale pour lancer l'application de conversion d'image.
     * <p>
     * Cette methode charge une image, calcule ses tables de frequences, de codes de Huffman
     * et de codes canoniques, puis affiche ces informations dans une fenetre avec onglets.
     * Elle permet egalement de convertir l'image en fichier PIF.
     * </p>
     *
     * @param args les arguments passes en ligne de commande, ou args[0] peut etre le chemin de l'image
     */
    public static void main(String[] args) {
        // Creation de l'objet pour charger l'image
        ChargementImage image = new ChargementImage();

        // Chargement de l'image
        BufferedImage img = null;
        if (args.length >= 1) {
            img = image.chargedImageCompressee(args[0]);
        } else {
            JFileChooser choose = new JFileChooser(new File("./res"));
            choose.setDialogTitle("Choisissez une image a convertir: ");
            int ress = choose.showOpenDialog(null);
            if (ress == JFileChooser.APPROVE_OPTION) {
                if (!choose.getSelectedFile().isDirectory()) {
                    img = image.chargedImageCompressee(choose.getSelectedFile());
                }
            }
        }
        BufferedImage imgbis = img;

        // Recuperation des tables de frequences pour chaque couleur
        int[] tableFreqRouge = TabFreq.RemplirTabFreq(img).getRouge();
        int[] tableFreqVert = TabFreq.RemplirTabFreq(img).getVert();
        int[] tableFreqBleu = TabFreq.RemplirTabFreq(img).getBleu();

        // Recuperation des tables de codes pour chaque couleur
        Map<Integer, String> tableCodeRouge = MHuffman.Encoder(tableFreqRouge);
        Map<Integer, String> tableCodeVert = MHuffman.Encoder(tableFreqVert);
        Map<Integer, String> tableCodeBleu = MHuffman.Encoder(tableFreqBleu);

        // Recuperation des tables canoniques pour chaque couleur
        Map<Integer, String> tableCanoRouge = MCanonique.EncoderEncore(tableCodeRouge);
        Map<Integer, String> tableCanoVert = MCanonique.EncoderEncore(tableCodeVert);
        Map<Integer, String> tableCanoBleu = MCanonique.EncoderEncore(tableCodeBleu);

        // Creation de la fenetre principale
        int maxWidth = 800;
        int maxHeight = 600;
        ImageIcon icon = redimensionnerImage(img, maxWidth, maxHeight);
        JFrame frame = new JFrame("Vous cherchez a convertir une image ?");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        // Onglet IMAGE
        JLabel imageaafficher = new JLabel(new ImageIcon(img));
        JButton bouton = new JButton("Convertir !");
        bouton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                ChoisirEtCreerPif choisir = new ChoisirEtCreerPif();
                File newfichierpif = choisir.choisirEtCreerFichierPif(args, frame);
                if (newfichierpif != null) {
                    PifCreator pifFile = new PifCreator(imgbis, newfichierpif, tableCanoRouge, tableCanoVert, tableCanoBleu);
                    pifFile.ecrirePif();
                }
            }
        });

        JPanel pourimage = new JPanel();
        pourimage.setLayout(new BorderLayout());
        pourimage.add(imageaafficher, BorderLayout.NORTH);
        pourimage.add(bouton, BorderLayout.SOUTH);

        // Onglet FREQUENCES
        JPanel pourtabfreq = new JPanel();
        JPanel tabfreqrouge = new JPanel();
        JPanel tabfreqvert = new JPanel();
        JPanel tabfreqbleu = new JPanel();

        tabfreqrouge.add(AfficherTabFreq.affichage(tableFreqRouge, "Rouge"));
        tabfreqvert.add(AfficherTabFreq.affichage(tableFreqVert, "Vert"));
        tabfreqbleu.add(AfficherTabFreq.affichage(tableFreqBleu, "Bleu"));
        pourtabfreq.add(new JLabel("Tables de frequence de l'image"));
        pourtabfreq.add(tabfreqrouge);
        pourtabfreq.add(tabfreqvert);
        pourtabfreq.add(tabfreqbleu);

        // Onglet CODES
        JPanel pourtabcode = new JPanel();
        JPanel tabcoderouge = new JPanel();
        JPanel tabcodevert = new JPanel();
        JPanel tabcodebleu = new JPanel();

        tabcoderouge.add(AfficherTabCode.affichage(tableCodeRouge, "Rouge"));
        tabcodevert.add(AfficherTabCode.affichage(tableCodeVert, "Vert"));
        tabcodebleu.add(AfficherTabCode.affichage(tableCodeBleu, "Bleu"));
        pourtabcode.add(new JLabel("Tables de codes de l'image"));
        pourtabcode.add(tabcoderouge);
        pourtabcode.add(tabcodevert);
        pourtabcode.add(tabcodebleu);

        // Onglet CANONIQUES
        JPanel pourtabcanonique = new JPanel();
        JPanel tabcanorouge = new JPanel();
        JPanel tabcanovert = new JPanel();
        JPanel tabcanobleu = new JPanel();

        tabcanorouge.add(AfficherTabCa.affichage(tableCanoRouge, "Rouge"));
        tabcanovert.add(AfficherTabCa.affichage(tableCanoVert, "Vert"));
        tabcanobleu.add(AfficherTabCa.affichage(tableCanoBleu, "Bleu"));
        pourtabcanonique.add(new JLabel("Tables canoniques de l'image"));
        pourtabcanonique.add(tabcanorouge);
        pourtabcanonique.add(tabcanovert);
        pourtabcanonique.add(tabcanobleu);

        // Creation des onglets
        JTabbedPane onglets = new JTabbedPane();
        onglets.add("Image", pourimage);
        onglets.add("Frequences", pourtabfreq);
        onglets.add("Codes", pourtabcode);
        onglets.add("Canoniques", pourtabcanonique);

        frame.setLayout(new BorderLayout());
        frame.add(onglets);

        frame.pack(); // adapte la fenetre au contenu
        frame.setLocationRelativeTo(null); // centre la fenetre
        frame.setVisible(true);
    }
}
