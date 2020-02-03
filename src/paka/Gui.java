package paka;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;

public class Gui {
    private JFrame ventana;
    private JPanel panel1;
    private JButton bot1, bot2;

    // Constructor que inicializa los componentes
    public Gui() {
        ventana = new JFrame();
        panel1 = new JPanel();
        bot1 = new JButton();
        bot2 = new JButton();
    }
    
    // Atributos de los componentes
    public void atributos() {
        ventana.setSize(400, 200);
        ventana.setResizable(true);
        bot1.setText("Aceptar");
        bot2.setText("Cancelar");
    }
    
    // Armar la interfaz
    public void armado() {
        ventana.add(panel1);
        panel1.add(bot1);
        panel1.add(bot2);
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