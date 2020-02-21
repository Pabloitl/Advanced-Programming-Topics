package CrazyButtons;

import java.awt.Color;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.Random;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;

public class CrazyButtons {
    private JFrame    window;
    private JPanel    mainPanel;
    private JButton[] crazyButtons;

    private final int WIDTH = 500, HEIGHT = 400;

    public CrazyButtons(int n) {
        window       = new JFrame("Crazy Buttons");
        mainPanel    = new JPanel();
        crazyButtons = new JButton[n];
        for (int i = 0; i < crazyButtons.length; i++)
            crazyButtons[i] = new JButton("Click me!!");

        this.atributos();
        this.armado();
        this.escuchas();
        this.lanzar_GUI();
    }

    // Atributos de los componentes
    public void atributos() {
        window.setSize(WIDTH, HEIGHT);
        window.setResizable(true);
        mainPanel.setBackground(Color.PINK);
        for (JButton btn : crazyButtons) {
            int factor = (int) (Math.random() * 32) + 32;
            btn.setBackground(new Color(factor * 4, factor * 3, factor * 3));
        }
    }

    // Armar la interfaz
    public void armado() {
        window.add(mainPanel);
        for (JButton btn : crazyButtons)
            mainPanel.add(btn);
    }

    // Asignar los escuchas
    public void escuchas() {
        MouseAdapter controller = new Escucha();

        for (JButton btn : crazyButtons)
            btn.addMouseListener(controller);
    }

    // Lanzar la interfaz gráfica
    public void lanzar_GUI() {
        window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        window.setLocationRelativeTo(null);
        window.setVisible(true);
    }

    private void positionate(JButton button) {
        Random generator = new Random();
        int x = generator.nextInt(WIDTH - button.getWidth());
        int y = generator.nextInt(HEIGHT - button.getHeight());

        button.setBounds(x, y, button.getWidth(), button.getHeight());
    }

    public class Escucha extends MouseAdapter {
        @Override
        public void mouseEntered(MouseEvent e) {
            for (JButton btn : crazyButtons)
                if(e.getComponent().equals(btn))
                    positionate(btn);
        }
    }
}
