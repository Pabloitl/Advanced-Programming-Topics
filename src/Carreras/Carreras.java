package Carreras;

import java.awt.FlowLayout;
import javax.swing.BoxLayout;
import javax.swing.ButtonGroup;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JRadioButton;

public class Carreras {
    JFrame window;
    ButtonGroup grupoCarreras;
    JRadioButton[] carreras;
    
    public Carreras(String[] nombresCarreras) {
        window = new JFrame();
        grupoCarreras = new ButtonGroup();
        carreras = new JRadioButton[nombresCarreras.length];
        for(int i = 0; i < carreras.length; ++i)
            carreras[i] = new JRadioButton(nombresCarreras[i]);
        
        this.atributos();
        this.armado();
        this.escuchas();
        this.lanzar_GUI();
    }

    public void atributos() {
        window.setSize(100, 300);
        window.setResizable(true);
        window.setLayout(
                new BoxLayout(window.getContentPane(), BoxLayout.Y_AXIS));
    }

    public void armado() {
        for(JRadioButton btn : carreras) {
            grupoCarreras.add(btn);
            window.add(btn);
        }
    }

    public void escuchas() {
    }

    public void lanzar_GUI() {
        window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        window.setLocationRelativeTo(null);
        window.setVisible(true);
    }
}
