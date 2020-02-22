package Galeria;

import java.awt.BorderLayout;
import java.awt.FlowLayout;
import java.awt.Image;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.io.File;
import java.io.FilenameFilter;
import java.util.Arrays;
import javax.swing.Icon;
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
    private final String SOURCE = "src/Galeria/Imagenes/";

    public Galeria() {
        imgSource      = new File(SOURCE);
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
            images[i].setIcon(scaleImage(SOURCE + imagesList[i], 100));
    }

    public void armado() {
        window.add(selectionPanel, BorderLayout.WEST);
        window.add(imagePanel, BorderLayout.CENTER);
        imagePanel.add(bigImage);
        for (JLabel img : images)
            selectionPanel.add(img);
    }

    public void escuchas() {
        Escucha controller = new Escucha();

        for (JLabel img : images) {
            img.addMouseListener(controller);
        }

    }

    public void lanzar_GUI() {
        window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        window.setLocationRelativeTo(null);
        window.setVisible(true);
    }

    private ImageIcon scaleImage(String source, int max) {
        return scaleImage(new ImageIcon(source), max);
    }

    private ImageIcon scaleImage(ImageIcon original, int max) {
        float ratio = 9 / 16f;
        ImageIcon scaled   = new ImageIcon(
                original.getImage().getScaledInstance(
                        max,
                        (int) (max * ratio),
                        Image.SCALE_AREA_AVERAGING));
        return scaled;
    }

    class Escucha extends MouseAdapter {
        @Override
        public void mouseClicked(MouseEvent e) {
            for (int i = 0; i < images.length; i++) {
                if (images[i].equals(e.getComponent())) {
                    String imgRoute = SOURCE + imgSource.list()[i];
                    bigImage.setIcon(scaleImage(imgRoute, window.getWidth() / 2));
                }
            }

        }
    }
}
