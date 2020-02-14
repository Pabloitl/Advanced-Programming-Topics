package FlowLayout;

import java.awt.FlowLayout;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;

public class Gui {
    private JFrame  ventana;
    private JPanel  panel;
    private JButton iscLbl;
    private JButton logLbl;
    private JButton elcLbl;
    private JButton mecLbl;
    private JButton gesLbl;

    // Constructor que inicializa los componentes
    public Gui() {
        ventana = new JFrame();
        panel   = new JPanel();
        iscLbl  = new JButton("Ing. Sistemas Computacionales");
        logLbl  = new JButton("Ing. Logistica");
        elcLbl  = new JButton("Ing. Electromecánica");
        mecLbl  = new JButton("Ing. Mecatrónica");
        gesLbl  = new JButton("Ing. Gestión Empresarial");
        this.atributos();
        this.armado();
        this.escuchas();
        this.lanzar_GUI();
    }

    // Atributos de los componentes
    public void atributos() {
        ventana.setSize(400, 200);
        ventana.setResizable(true);
        panel.setLayout(new FlowLayout());
    }

    // Armar la interfaz
    public void armado() {
        ventana.add(panel);
        panel.add(iscLbl);
        panel.add(logLbl);
        panel.add(elcLbl);
        panel.add(mecLbl);
        panel.add(gesLbl);
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
