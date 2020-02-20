package MensajeICPC;

import java.awt.GridLayout;
import java.awt.FlowLayout;
import java.awt.BorderLayout;
import java.awt.Color;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.border.LineBorder;

public class Gui {
    public static int  HEIGHT = 8, WIDTH = 7;
    private JPanel     matrixPanel;
    private JPanel[][] matrixPanels;
    private JLabel[][] matrixLabels;
    private LineBorder matrixBorder;
    private JPanel     respuestaPanel;
    private JLabel     respuestaLabel;
    private JFrame     ventana;

    // Constructor que inicializa los componentes
    public Gui() {
        ventana        = new JFrame();
        matrixPanel    = new JPanel();
        matrixPanels   = new JPanel[HEIGHT][WIDTH];
        matrixLabels   = new JLabel[HEIGHT][WIDTH];
        matrixBorder   = new LineBorder(Color.BLACK, HEIGHT / 8, true);
        respuestaPanel = new JPanel();
        respuestaLabel = new JLabel();
        for (int i = 0; i < HEIGHT; i++)
            for (int j = 0; j < WIDTH; j++) {
                matrixPanels[i][j] = new JPanel();
                matrixLabels[i][j] = new JLabel();
            }

        this.atributos();
        this.armado();
        this.escuchas();
        this.lanzar_GUI();
    }

    // Atributos de los componentes
    public void atributos() {
        String input = JOptionPane.showInputDialog(null, "Appointment: ");

        ventana.setSize(500, 500);
        ventana.setResizable(true);
        ventana.setLayout(new BorderLayout());
        matrixPanel.setLayout(new GridLayout(HEIGHT, WIDTH));
        respuestaPanel.setLayout(new FlowLayout());
        respuestaLabel.setHorizontalAlignment(JLabel.CENTER);
        respuestaPanel.setBorder(matrixBorder);
        respuestaPanel.setBackground(Color.LIGHT_GRAY);
        new Encripcion().solve(input, matrixPanels, matrixLabels, respuestaLabel);
        for (int i = 0; i < HEIGHT; i++)
            for (int j = 0; j < WIDTH; j++) {
                matrixPanels[i][j].setBorder(matrixBorder);
                matrixPanels[i][j].setLayout(new BorderLayout());
                matrixLabels[i][j].setHorizontalAlignment(JLabel.CENTER);
            }
    }

    // Armar la interfaz
    public void armado() {
        respuestaPanel.add(respuestaLabel);
        ventana.add(matrixPanel, BorderLayout.CENTER);
        ventana.add(respuestaPanel, BorderLayout.SOUTH);
        for (int i = 0; i < HEIGHT; i++)
            for (int j = 0; j < WIDTH; j++) {
                matrixPanel.add(matrixPanels[i][j]);
                matrixPanels[i][j].add(matrixLabels[i][j], BorderLayout.CENTER);
            }
    }

    // Asignar los escuchas
    public void escuchas() {
        // vacío por lo pronto
    }

    // Lanzar la interfaz gráfica
    public void lanzar_GUI() {
        ventana.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        ventana.setLocationRelativeTo(null);
        ventana.setVisible(true);
    }
}
