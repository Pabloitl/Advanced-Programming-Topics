package GridBagLayout;

import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import javax.swing.JButton;
import javax.swing.JFrame;

public class Gui {
    private JFrame ventana;
    private JButton[] buttons;

    public Gui() {
        ventana = new JFrame("Ejemplo GridBagLayout");
        buttons = new JButton[10];
        for (int i = 0; i < buttons.length; i++)
            buttons[i] = new JButton("Botón " + (i + 1));
        
        this.atributos();
        this.armado();
        this.escuchas();
        this.lanzar_GUI();
    }

    public void atributos() {
        ventana.setSize(400, 400);
        ventana.setLayout(new GridBagLayout());
    }

    public void armado() {
        GridBagConstraints gc = new GridBagConstraints();
        
        gc.fill = GridBagConstraints.BOTH;
        gc.weightx = gc.weighty = .1;
        for (int i = 0; i < 4; gc.gridx = ++i)
            ventana.add(buttons[i], gc);
        gc.gridx = 0;
        gc.gridy = 1;
        gc.gridwidth = 4;
        ventana.add(buttons[4], gc);
        gc.gridy = 2;
        gc.gridwidth = 3;
        ventana.add(buttons[5], gc);
        gc.gridwidth = 1;
        gc.gridx = 3;
        ventana.add(buttons[6], gc);
        gc.gridx = 0;
        gc.gridy = 3;
        gc.gridheight = 2;
        ventana.add(buttons[7], gc);
        gc.gridx = 1;
        gc.gridheight = 1;
        gc.gridwidth = 3;
        ventana.add(buttons[8], gc);
        gc.gridy = 4;
        ventana.add(buttons[9], gc);
    }

    public void escuchas() {
    }

    public void lanzar_GUI() {
        ventana.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        ventana.setLocationRelativeTo(null);
        ventana.setVisible(true);
    }
}
