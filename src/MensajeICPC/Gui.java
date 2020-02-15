package MensajeICPC;

import java.awt.BorderLayout;
import java.awt.GridLayout;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

public class Gui {
    public static int HEIGHT = 8, WIDTH = 7;
    private JPanel[][] panels;
    private JPanel[]   respuestaPanels;
    private JLabel[]   respuestaLabels;
    private JFrame ventana;

    // Constructor que inicializa los componentes
    public Gui() {
        ventana = new JFrame();
        panels = new JPanel[HEIGHT][WIDTH];
        respuestaPanels = new JPanel[HEIGHT];
        respuestaLabels = new JLabel[HEIGHT];
        for (int i = 0; i < HEIGHT; i++) {
            for (int j = 0; j < WIDTH; j++)
                panels[i][j] = new JPanel();
            respuestaPanels[i] = new JPanel();
            respuestaLabels[i] = new JLabel();
        }

        this.atributos();
        this.armado();
        this.escuchas();
        this.lanzar_GUI();
    }

    // Atributos de los componentes
    public void atributos() {
        String input = JOptionPane.showInputDialog(null, "Appointment: ");

        ventana.setSize(400, 400);
        ventana.setResizable(true);
        ventana.setLayout(new GridLayout(HEIGHT, WIDTH + 1));
        new Encripcion().solve(input, panels, respuestaLabels);
    }

    // Armar la interfaz
    public void armado() {
        for (int i = 0; i < HEIGHT; i++) {
            for (int j = 0; j < WIDTH; j++)
                ventana.add(panels[i][j]);
            ventana.add(respuestaPanels[i]);
            respuestaPanels[i].add(respuestaLabels[i]);
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