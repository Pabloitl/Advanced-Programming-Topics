package Galeria;

import java.awt.BorderLayout;
import java.awt.FlowLayout;
import java.awt.Image;
import java.io.File;
import java.io.FilenameFilter;
import java.util.Arrays;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.filechooser.FileNameExtensionFilter;

public class Galeria {
    private JFrame window;
    private JPanel selectionPanel, imagePanel;
    private JLabel bigImage;
    private JLabel[] images;

    private final File imgSource;
    private final int WIDTH = 400, HEIGHT = 400;
    private final String imageSource = "src/Galeria/Imagenes/";

    public Galeria() {
        imgSource      = new File(imageSource);
        window         = new JFrame();
        selectionPanel = new JPanel();
        imagePanel     = new JPanel();
        bigImage       = new JLabel();
        images         = new JLabel[imgSource.list().length];
        for (int i = 0; i < images.length; i++)
            images[i] = new JLabel();

        this.atributos();
        this.armado();
        this.escuchas();
        this.lanzar_GUI();
    }

    public void atributos() {
        String[] imagesList = imgSource.list();
        window.setSize(WIDTH, HEIGHT);
        window.setResizable(true);
        window.setLayout(new BorderLayout());
        selectionPanel.setLayout(new FlowLayout());
        for (int i = 0; i < images.length; i++)
            images[i].setIcon(scaleImage(imageSource + imagesList[i], 100));
    }

    public void armado() {
        window.add(selectionPanel, BorderLayout.WEST);
        // window.add(imagePanel, BorderLayout.EAST);
        // imagePanel.add(bigImage);
        for (JLabel img : images)
            selectionPanel.add(img);
    }

    public void escuchas() {
    }

    public void lanzar_GUI() {
        window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        window.setLocationRelativeTo(null);
        window.setVisible(true);
    }

    private ImageIcon scaleImage(String source, int max) {
        ImageIcon original = new ImageIcon(source);
        float ratio = 9 / 16f;
        ImageIcon scaled   = new ImageIcon(
                original.getImage().getScaledInstance(
                        max,
                        (int) (max * ratio),
                        Image.SCALE_AREA_AVERAGING));
        return scaled;
    }
}
