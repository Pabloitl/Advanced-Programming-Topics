package Listener;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionListener;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.SwingConstants;
import javax.swing.JPanel;

public class Gui {
    private JFrame ventana;
    private JPanel panelC;
    private JLabel southLabel;

    // Constructor que inicializa los componentes
    public Gui() {
        ventana    = new JFrame();
        panelC     = new JPanel();
        southLabel = new JLabel("Mouse Fuera");

        this.atributos();
        this.armado();
        this.escuchas();
        this.lanzar_GUI();
    }

    // Atributos de los componentes
    public void atributos() {
        ventana.setSize(400, 400);
        ventana.setResizable(true);
        panelC.setLayout(new BorderLayout());
        southLabel.setHorizontalAlignment(SwingConstants.CENTER);
    }

    // Armar la interfaz
    public void armado() {
        ventana.add(panelC, BorderLayout.CENTER);
        ventana.add(southLabel, BorderLayout.SOUTH);
    }

    // Asignar los escuchas
    public void escuchas() {
        EscuchaRaton escucha = new EscuchaRaton();
        panelC.addMouseListener(escucha);
        panelC.addMouseMotionListener(escucha);
        // panelC.addMouseListener(new MouseListener() {
        //         @Override
        //         public void mouseClicked(MouseEvent me) {
        //             southLabel.setText("Mouse Adentro. click");
        //         }

        //         @Override
        //         public void mousePressed(MouseEvent me) {
        //             String position = "";
        //             int boton = me.getButton();
        //             switch (boton) {
        //             case 1:
        //                 position = "IZQUIERDO";
        //                 break;
        //             case 2:
        //                 position = "CENTRAL";
        //                 break;
        //             case 3:
        //                 position = "DERECHO";
        //                 break;
        //             }
        //             southLabel.setText("Mouse Adentro " + position + " (X: " + me.getX() + " Y: " + me.getY() + ")");
        //         }

        //         @Override
        //         public void mouseReleased(MouseEvent me) {
        //             southLabel.setText("Mouse Adentro, Soltaste el boton");
        //         }

        //         @Override
        //         public void mouseEntered(MouseEvent me) {
        //             panelC.setBackground(Color.RED);
        //             southLabel.setText("Mouse Adentro");
        //         }

        //         @Override
        //         public void mouseExited(MouseEvent me) {
        //             panelC.setBackground(Color.PINK);
        //             southLabel.setText("Mouse Afuera");
        //         }
        //     });
    }

    // Lanzar la interfaz gráfica
    public void lanzar_GUI() {
        ventana.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        ventana.setLocationRelativeTo(null);
        ventana.setVisible(true);
    }

    // /**
    //  * Clase que controlla los eventos
    //  *
    //  */
    // class EscuchaRaton implements MouseListener, MouseMotionListener {
    //     @Override
    //     public void mouseClicked(MouseEvent me) {
    //         southLabel.setText("Mouse Adentro. click");
    //     }

    //     @Override
    //     public void mousePressed(MouseEvent me) {
    //         String position = "";
    //         int boton = me.getButton();
    //         switch (boton) {
    //         case 1:
    //             position = "IZQUIERDO";
    //             break;
    //         case 2:
    //             position = "CENTRAL";
    //             break;
    //         case 3:
    //             position = "DERECHO";
    //             break;
    //         }
    //         southLabel.setText("Mouse Adentro " + position + " (X: " + me.getX() + " Y: " + me.getY() + ")");
    //     }

    //     @Override
    //     public void mouseReleased(MouseEvent me) {
    //     }

    //     @Override
    //     public void mouseEntered(MouseEvent me) {
    //         panelC.setBackground(Color.RED);
    //         southLabel.setText("Mouse Adentro");
    //     }

    //     @Override
    //     public void mouseExited(MouseEvent me) {
    //         panelC.setBackground(Color.PINK);
    //         southLabel.setText("Mouse Afuera");
    //     }

    //     @Override
    //     public void mouseDragged(MouseEvent me) {
    //     }

    //     @Override
    //     public void mouseMoved(MouseEvent me) {
    //         southLabel.setText("Mouse moviendose " + " (X: " + me.getX() + " Y: " + me.getY() + ")");
    //     }
    // }

    class EscuchaRaton extends MouseAdapter {
        @Override
        public void mouseMoved(MouseEvent me) {
            southLabel.setText("Mouse moviendose " + " (X: " + me.getX() + " Y: " + me.getY() + ")");
        }
    }
}
