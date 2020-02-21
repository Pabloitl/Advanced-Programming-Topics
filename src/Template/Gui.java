package Template;

import java.awt.BorderLayout;
import java.awt.Color;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class Gui {
    private JFrame  ventana;
    private JPanel  panelN;
    private JPanel  panelS;
    private JPanel  panelE;
    private JPanel  panelO;
    private JPanel  panelC;
    private JPanel  panelCN;
    private JPanel  panelCS;
    private JPanel  panelCE;
    private JPanel  panelCO;
    private JPanel  panelCC;
    // private JButton bot1;
    // private JButton bot2;
    private JLabel  lblNorte;
    private JLabel  lblSur;
    private JLabel  lblEste;
    private JLabel  lblOeste;
    private JLabel  lblCentro;

    // Constructor que inicializa los componentes
    public Gui() {
        ventana   = new JFrame();
        panelN    = new JPanel();
        panelS    = new JPanel();
        panelE    = new JPanel();
        panelO    = new JPanel();
        panelC    = new JPanel();
        panelCN   = new JPanel();
        panelCS   = new JPanel();
        panelCE   = new JPanel();
        panelCO   = new JPanel();
        panelCC   = new JPanel();
        // bot1      = new JButton();
        // bot2      = new JButton();
        lblNorte  = new JLabel("Panel del Norte");
        lblSur    = new JLabel("Panel del Sur");
        lblEste   = new JLabel("Panel del Este");
        lblOeste  = new JLabel("Panel del Oeste");
        lblCentro = new JLabel("Panel del Centro");
        this.atributos();
        this.armado();
        this.escuchas();
        this.lanzar_GUI();
    }

    // Atributos de los componentes
    public void atributos() {
        ventana.setSize(400, 200);
        ventana.setResizable(true);
        // panelN.
        // panelS.
        // panelE.
        // panelO.
        // panelC.
        panelC.setLayout(new BorderLayout());
        panelCN.setBackground(Color.CYAN);
        panelCS.setBackground(Color.MAGENTA);
        panelCE.setBackground(Color.ORANGE);
        panelCO.setBackground(Color.YELLOW);
        panelCC.setBackground(Color.BLUE);
        // bot1.setText("Aceptar");
        // bot2.setText("Cancelar");
        lblSur.setForeground(panelC.getBackground());
    }

    // Armar la interfaz
    public void armado() {
        ventana.add(panelN, BorderLayout.NORTH);
        ventana.add(panelS, BorderLayout.SOUTH);
        ventana.add(panelE, BorderLayout.EAST);
        ventana.add(panelO, BorderLayout.WEST);
        ventana.add(panelC, BorderLayout.CENTER);
        panelC.add(panelCN, BorderLayout.NORTH);
        panelC.add(panelCS, BorderLayout.SOUTH);
        panelC.add(panelCE, BorderLayout.EAST);
        panelC.add(panelCO, BorderLayout.WEST);
        panelC.add(panelCC, BorderLayout.CENTER);
        panelCN.add(lblNorte);
        panelCS.add(lblSur);
        panelCE.add(lblEste);
        panelCO.add(lblOeste);
        panelCN.add(lblCentro);
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
