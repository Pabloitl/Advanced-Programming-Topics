package GridLayout;

import java.awt.GridLayout;
import java.awt.Color;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;

public class Gui {
    private JFrame    ventana;
    private JPanel[]  panels;
    private JButton[] buttons;
    
    private final int DIM = 30,
            WIDTH = 5,
            HEIGHT = 6;

    // Constructor que inicializa los componentes
    public Gui() {
        ventana = new JFrame("Prueba de Grid con Panel y botones");
        panels  = new JPanel[DIM];
        buttons = new JButton[DIM];
        for(int i = 0; i < DIM; ++i) {
            panels[i]  = new JPanel();
            buttons[i] = new JButton();
        }
        this.atributos();
        this.armado();
        this.escuchas();
        this.lanzar_GUI();
    }

    // Atributos de los componentes
    public void atributos() {
        ventana.setSize(700, 400);
        ventana.setResizable(true);
        ventana.setLayout(new GridLayout(WIDTH, HEIGHT));
        for (int i = 0; i < DIM; i++) {
            buttons[i].setText("Celda " + (i + 1));
            panels[i].setBackground(new Color(
            (int) (Math.random() * 100),
            (int) (Math.random() * 30),
            (int) (Math.random() * 40)));
        }
    }

    // Armar la interfaz
    public void armado() {
        for (int i = 0; i < DIM; i++) {
            panels[i].add(buttons[i]);
            ventana.add(panels[i]);
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
