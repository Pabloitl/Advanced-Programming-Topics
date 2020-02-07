package Tarea1;

import java.awt.BorderLayout;
import java.awt.Color;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.ImageIcon;

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
    private JLabel  lblNorte;
    private JLabel  lblSur;
    private JLabel  lblEste;
    private JLabel  lblOeste;
    private JLabel  lblCentro;
    private JLabel  lblNorteImg;
    private JLabel  lblSurImg;
    private JLabel  lblEsteImg;
    private JLabel  lblOesteImg;
    private JLabel  lblCentroImg;

    // Constructor que inicializa los componentes
    public Gui() {
        ventana      = new JFrame();
        panelN       = new JPanel();
        panelS       = new JPanel();
        panelE       = new JPanel();
        panelO       = new JPanel();
        panelC       = new JPanel();
        panelCN      = new JPanel();
        panelCS      = new JPanel();
        panelCE      = new JPanel();
        panelCO      = new JPanel();
        panelCC      = new JPanel();
        lblNorte     = new JLabel("Panel del Norte");
        lblSur       = new JLabel("Panel del Sur");
        lblEste      = new JLabel("Panel del Este");
        lblOeste     = new JLabel("Panel del Oeste");
        lblCentro    = new JLabel("Panel del Centro");
        lblNorteImg  = new JLabel();
        lblSurImg    = new JLabel();
        lblEsteImg   = new JLabel();
        lblOesteImg  = new JLabel();
        lblCentroImg = new JLabel();
        this.atributos();
        this.armado();
        this.escuchas();
        this.lanzar_GUI();
    }

    // Atributos de los componentes
    public void atributos() {
        ventana.setSize(400, 200);
        ventana.setResizable(true);
        panelC.setLayout(new BorderLayout());
        panelCN.setBackground(Color.CYAN);
        panelCS.setBackground(Color.MAGENTA);
        panelCE.setBackground(Color.LIGHT_GRAY);
        panelCO.setBackground(Color.YELLOW);
        panelCC.setBackground(new Color(255, 153, 204));
        lblNorteImg.setIcon(new ImageIcon("src/Tarea1/Imagenes/north.png"));
        lblSurImg.setIcon(new ImageIcon("src/Tarea1/Imagenes/south.png"));
        lblEsteImg.setIcon(new ImageIcon("src/Tarea1/Imagenes/east.png"));
        lblOesteImg.setIcon(new ImageIcon("src/Tarea1/Imagenes/west.png"));
        lblCentroImg.setIcon(new ImageIcon("src/Tarea1/Imagenes/center.png"));
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
        panelCC.add(lblCentroImg);
        panelCC.add(lblCentro);
        panelN.add(lblNorteImg);
        panelS.add(lblSurImg);
        panelE.add(lblEsteImg);
        panelO.add(lblOesteImg);
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
