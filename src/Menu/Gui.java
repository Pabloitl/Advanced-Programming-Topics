package Menu;

import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.event.KeyEvent;
import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.KeyStroke;

public class Gui {
    JFrame window;
    JMenuBar menuBar;
    JMenu[] menu;
    JMenuItem[] menuItem;
    JMenu ventanaMenu;
    JMenuItem[] ventanaItem;

    String[] menuTitles = {
        "Datos",
        "Procesos",
        "Editar",
        "Opciones",
        "Ventana",
        "Ayuda"
    };

    String[] itemTitles = {
        "Cascada",
        "Mosaico",
        "Anterior",
        "Posterior",
        "Opciones principales",
    };

    String[] ventanaTitles = {
        "Grabar área de trabajo",
        "Recuperar área de trabajo",
        "Cambiar estado"
    };

    public Gui() {
        window = new JFrame();
        menuBar = new JMenuBar();
        menu = new JMenu[menuTitles.length];
        for (int i = 0; i < menu.length; i++)
            menu[i] = new JMenu(menuTitles[i]);
        menuItem = new JMenuItem[itemTitles.length];
        for (int i = 0; i < menuItem.length; i++)
            menuItem[i] = new JMenuItem(itemTitles[i]);
        ventanaMenu = new JMenu("Área de trabajo");
        ventanaItem = new JMenuItem[ventanaTitles.length];
        for (int i = 0; i < ventanaItem.length; i++)
            ventanaItem[i] = new JMenuItem(ventanaTitles[i]);

        this.atributos();
        this.armado();
        this.escuchas();
        this.lanzar_GUI();
    }

    public void atributos() {
        window.setSize(400, 400);
        window.setResizable(true);
        menuItem[2].setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_A,
                ActionEvent.CTRL_MASK));
        menuItem[3].setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_P,
                ActionEvent.CTRL_MASK));
        menuItem[4].setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_F10, 0));
    }

    public void armado() {
        for (JMenu m : menu)
            menuBar.add(m);
        for (JMenuItem m : menuItem)
            menu[menu.length - 2].add(m);
        menu[menu.length - 2].addSeparator();
        for (JMenuItem m : ventanaItem)
            ventanaMenu.add(m);
        menu[menu.length - 2].add(ventanaMenu);
        window.add(menuBar, BorderLayout.NORTH);
    }

    public void escuchas() {
    }

    public void lanzar_GUI() {
        window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        window.setLocationRelativeTo(null);
        window.setVisible(true);
    }
}
