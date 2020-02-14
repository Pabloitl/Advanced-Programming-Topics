package Ajedrez;

import java.awt.Color;
import java.awt.GridLayout;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

public class Gui {
    private JFrame  ventana;
    private JPanel[] panels;
    private JButton[] buttons;
    private int width, height;

    private final int DIM_LIMIT = 50;

    // Constructor que inicializa los componentes
    public Gui(int width, int height) {
        if(validate(width) || validate(height)) return;
        
        ventana = new JFrame();
        panels = new JPanel[width * height];
        buttons = new JButton[width * height];
        
        for (int i = 0; i < width * height; ++i) {
            panels[i] = new JPanel();
            buttons[i] = new JButton();
        }
        this.width = width;
        this.height = height;
        this.atributos();
        this.armado();
        this.escuchas();
        this.lanzar_GUI();
    }

    // Atributos de los componentes
    public void atributos() {
        ventana.setSize(400, 400);
        ventana.setResizable(true);
        ventana.setLayout(new GridLayout(height, width));
        for (int i = 0; i < height; i++) {
            boolean odd = i % 2 == 0;

            for (int j = 0; j < width; j++) {
                panels[i * width + j].setBackground(
                    ((j % 2 == 0) == odd)
                        ? Color.WHITE
                        : Color.BLACK);
            }
        }
    }

    // Armar la interfaz
    public void armado() {
        for (int i = 0; i < width * height; i++) {
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
    
    private boolean validate(int x) {
        if(x <= 0 || x > DIM_LIMIT) {
            JOptionPane.showMessageDialog(null,
                    "Las dimensiones no son validas");
            return true;
        }
        return false;
    }
}
