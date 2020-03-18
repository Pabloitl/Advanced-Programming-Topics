package Lista;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Font;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.ListSelectionModel;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;

public class Gui {
    JFrame window;
    JLabel selectedLabel;
    JPanel colorPanel;
    JList fgList, bgList;
    JScrollPane fgScrollPane, bgScrollPane;

    enum ColorEnum {
        BLANCO (255, 255, 255),
        ROJO (255, 0, 0),
        NARANJA (230, 126, 34),
        AMARILLO (255, 255, 0),
        VERDE (0, 128, 0),
        AZUL (0, 0, 255),
        MORADO (128, 0, 128),
        CAFE (128, 0, 0),
        NEGRO (0, 0, 0),
        SALMON (250, 128, 114),
        ROJO_OSCURO (139, 0, 0),
        CORAL (255, 127, 80),
        TOMATE (255, 99, 71),
        DORADO (255, 215, 0),
        KHAKI (240, 230, 140),
        LAVANDA (230, 230, 250),
        OLIVA (128, 128, 0),
        CHOCOLATE (210, 105, 30);

        private int r, g, b;

        public int getR() {
            return r;
        }

        public int getG() {
            return g;
        }

        public int getB() {
            return b;
        }

        private ColorEnum(int r, int g, int b) {
            this.r = r;
            this.g = g;
            this.b = b;
        }
    }

    public Gui() {
        window        = new JFrame();
        selectedLabel = new JLabel();
        colorPanel    = new JPanel();
        fgList        = new JList(ColorEnum.values());
        bgList        = new JList(ColorEnum.values());
        fgScrollPane  = new JScrollPane(fgList);
        bgScrollPane  = new JScrollPane(bgList);

        this.atributos();
        this.armado();
        this.escuchas();
        this.lanzar_GUI();
    }

    public void atributos() {
        window.setSize(700, 250);
        window.setResizable(true);
        window.setLayout(new BorderLayout());
        colorPanel.setLayout(new BorderLayout());
        selectedLabel.setHorizontalAlignment(JLabel.CENTER);
        selectedLabel.setText("Area de prueba");
        selectedLabel.setFont(new Font("Arial", Font.ITALIC, 24));
        fgList.setSelectedIndex(0);
        fgList.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
        fgList.setFont(new Font("Arial", Font.BOLD, 20));
        bgList.setSelectedIndex(0);
        bgList.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
        bgList.setFont(new Font("Arial", Font.BOLD, 20));
        updateColors((ColorEnum) fgList.getSelectedValue(),
                     (ColorEnum) bgList.getSelectedValue());
    }

    public void armado() {
        colorPanel.add(selectedLabel, BorderLayout.CENTER);
        window.add(colorPanel, BorderLayout.CENTER);
        window.add(fgScrollPane, BorderLayout.WEST);
        window.add(bgScrollPane, BorderLayout.EAST);
    }

    public void escuchas() {
        Escucha escucha = new Escucha();

        fgList.addListSelectionListener(escucha);
        bgList.addListSelectionListener(escucha);
    }

    public void lanzar_GUI() {
        window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        window.setLocationRelativeTo(null);
        window.setVisible(true);
    }

    private void updateColors(ColorEnum fg, ColorEnum bg) {
        colorPanel.setBackground(new Color(bg.getR(),
                                           bg.getG(),
                                           bg.getB()));
        selectedLabel.setForeground(new Color(fg.getR(),
                                              fg.getG(),
                                              fg.getB()));
    }

    class Escucha implements ListSelectionListener {
        @Override
        public void valueChanged(ListSelectionEvent lse) {
            updateColors((ColorEnum) fgList.getSelectedValue(),
                         (ColorEnum) bgList.getSelectedValue());
        }
    }
}
