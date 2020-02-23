package Galeria;

import java.awt.BorderLayout;
import java.awt.FlowLayout;
import java.awt.Image;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.io.File;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class Galeria {
    private JFrame window;
    private JPanel selectionPanel, imagePanel;
    private JLabel bigImage;
    private JLabel[] images;

    private final File imgSource;
    private final int WIDTH = 400, HEIGHT = 400,
            THUMBNAIL_SIZE = WIDTH / 4, BIG_IMAGE_SIZE = WIDTH * 3 / 4 - WIDTH / 8;
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
        imagePanel.setLayout(new BorderLayout());
        bigImage.setIcon(scaleImage(SOURCE + imagesList[0], BIG_IMAGE_SIZE));
        for (int i = 0; i < images.length; i++)
            images[i].setIcon(scaleImage(SOURCE + imagesList[i], THUMBNAIL_SIZE));
    }

    public void armado() {
        window.add(selectionPanel, BorderLayout.CENTER);
        window.add(imagePanel, BorderLayout.EAST);
        imagePanel.add(bigImage, BorderLayout.CENTER);
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
        float ratio = original.getIconHeight() / (float) original.getIconWidth();
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
            for (int i = 0; i < images.length; i++)
                if (images[i].equals(e.getComponent())) {
                    String imgRoute = SOURCE + imgSource.list()[i];
                    bigImage.setIcon(scaleImage(imgRoute, BIG_IMAGE_SIZE));
                }
        }
    }
}
