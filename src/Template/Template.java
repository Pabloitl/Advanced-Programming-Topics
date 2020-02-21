package Template;

import javax.swing.JFrame;

public class Template {
    JFrame window;
    
    public Template() {
        window = new JFrame();
        
        this.atributos();
        this.armado();
        this.escuchas();
        this.lanzar_GUI();
    }

    public void atributos() {
        window.setSize(700, 400);
        window.setResizable(true);
    }

    public void armado() {
    }

    public void escuchas() {
    }

    public void lanzar_GUI() {
        window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        window.setLocationRelativeTo(null);
        window.setVisible(true);
    }
}
