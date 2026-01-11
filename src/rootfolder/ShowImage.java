package rootfolder;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;


/**
 * La classe ShowImage permet d'afficher une image a partir d'un fichier au format PIF.
 * <p>
 * Cette classe charge un fichier PIF, lit son contenu pour reconstruire l'image,
 * puis affiche cette image dans une fenetre redimensionnable avec une barre de defilement.
 * </p>
 */
public class ShowImage {

    /**
     * Methode principale pour lancer l'application d'affichage d'image PIF.
     * <p>
     * Cette methode permet a l'utilisateur de selectionner un fichier PIF,
     * lit le fichier pour reconstruire l'image, puis affiche l'image dans une fenetre.
     * </p>
     *
     * @param args les arguments passes en ligne de commande, ou args[0] peut etre le chemin du fichier PIF
     */
    public static void main(String[] args) {
        File fichierpif = null;

        // Choix du fichier .pif
        if (args.length >= 1) {
            if (!args[0].endsWith(".pif")) {
                JOptionPane.showMessageDialog(null, "Votre fichier n'a pas le bon format :(");
                return;
            }
            fichierpif = new File(args[0]);
        } else {
            JFileChooser choose = new JFileChooser(new File("./res"));
            choose.setDialogTitle("Choisissez une image a afficher : ");
            int res = choose.showOpenDialog(null);
            if (res != JFileChooser.APPROVE_OPTION || choose.getSelectedFile().isDirectory()) {
                return;
            }
            if (!choose.getSelectedFile().getName().endsWith(".pif")) {
                JOptionPane.showMessageDialog(null, "Votre fichier n'a pas le bon format :(");
                return;
            }
            fichierpif = choose.getSelectedFile();
        }

        if (!fichierpif.exists() || !fichierpif.isFile()) {
            JOptionPane.showMessageDialog(null, "Fichier introuvable : " + fichierpif.getAbsolutePath());
            return;
        }

        // Lecture du fichier PIF
        PifReader pifFile = new PifReader(fichierpif);
        try {
            pifFile.lirePif();
        } catch (IOException e) {
            JOptionPane.showMessageDialog(null, "Erreur lors de la lecture du fichier .pif");
            return;
        }

        BufferedImage imgbis = pifFile.getImage();

        // Creation de la fenetre
        JFrame frame = new JFrame("Vous visualisez un fichier .pif !");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setResizable(true); // fenetre redimensionnable

        // Affichage de l'image dans un JLabel
        JLabel imageLabel = new JLabel(new ImageIcon(imgbis));
        imageLabel.setHorizontalAlignment(JLabel.CENTER);
        imageLabel.setVerticalAlignment(JLabel.CENTER);

        // Scroll pane pour deplacer l'image si elle est trop grande
        JScrollPane scrollPane = new JScrollPane(imageLabel);
        scrollPane.setPreferredSize(adaptedSize(imgbis));
        scrollPane.getViewport().setScrollMode(JViewport.SIMPLE_SCROLL_MODE); // plus fluide

        frame.add(scrollPane, BorderLayout.CENTER);
        frame.pack();
        frame.setLocationRelativeTo(null); // centrer la fenetre
        frame.setVisible(true);
    }

    /**
     * Calcule une taille adaptee a l'ecran pour l'affichage de l'image.
     * <p>
     * Cette methode ajuste les dimensions de l'image pour qu'elle ne depasse pas
     * 80% de la largeur et de la hauteur de l'ecran, tout en conservant les proportions.
     * </p>
     *
     * @param img l'image dont on veut adapter la taille
     * @return une instance de Dimension representant la taille adaptee
     */
    private static Dimension adaptedSize(BufferedImage img) {
        Dimension screen = Toolkit.getDefaultToolkit().getScreenSize();
        int maxWidth = (int) (screen.width * 0.8);  // pas plus de 80% largeur ecran
        int maxHeight = (int) (screen.height * 0.8); // pas plus de 80% hauteur ecran

        int width = img.getWidth();
        int height = img.getHeight();

        if (width > maxWidth) {
            double ratio = (double) maxWidth / width;
            width = maxWidth;
            height = (int) (height * ratio);
        }

        if (height > maxHeight) {
            double ratio = (double) maxHeight / height;
            height = maxHeight;
            width = (int) (width * ratio);
        }

        return new Dimension(width, height);
    }
}

