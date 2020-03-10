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
    JList colorsList;
    JScrollPane scrollPane;
    JLabel selectedLabel;
    JPanel colorPanel;
    
    enum ColorEnum {
        BLANCO (255, 255, 255),
        ROJO (255, 0, 0),
        NARANJA (230, 126, 34),
        AMARILLO (255, 255, 0),
        VERDE (0, 128, 0),
        AZUL (0, 0, 255),
        MORADO (128, 0, 128),
        CAFE (128, 0, 0),
        NEGRO (0, 0, 0);

        public int getR() {
            return r;
        }

        public int getG() {
            return g;
        }

        public int getB() {
            return b;
        }
        
        private int r, g, b;
        
        private ColorEnum(int r, int g, int b) {
            this.r = r;
            this.g = g;
            this.b = b;
        }
    }
    
    public Gui() {
        window        = new JFrame();
        colorsList    = new JList(ColorEnum.values());
        scrollPane    = new JScrollPane(colorsList);
        selectedLabel = new JLabel();
        colorPanel    = new JPanel();
        
        this.atributos();
        this.armado();
        this.escuchas();
        this.lanzar_GUI();
    }

    public void atributos() {
        window.setSize(700, 170);
        window.setResizable(true);
        window.setLayout(new BorderLayout());
        colorsList.setSelectedIndex(0);
        colorsList.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
        colorsList.setFont(new Font("Arial", Font.BOLD, 20));
        selectedLabel.setText(colorsList.getSelectedValue().toString());
        selectedLabel.setHorizontalAlignment(JLabel.CENTER);
    }

    public void armado() {
        window.add(scrollPane, BorderLayout.WEST);
        window.add(selectedLabel, BorderLayout.SOUTH);
        window.add(colorPanel, BorderLayout.CENTER);
    }

    public void escuchas() {
        colorsList.addListSelectionListener(new Escucha());
    }

    public void lanzar_GUI() {
        window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        window.setLocationRelativeTo(null);
        window.setVisible(true);
    }
    
    class Escucha implements ListSelectionListener {
        @Override
        public void valueChanged(ListSelectionEvent lse) {
            ColorEnum selected =
                    (ColorEnum) colorsList.getSelectedValue();
            
            colorPanel.setBackground(new Color(selected.getR(), selected.getG(),
            selected.getB()));
            selectedLabel.setText("");
            selectedLabel.setText(selected.toString());
            for (int i : colorsList.getSelectedIndices())
                selectedLabel.setText(selectedLabel.getText() + " " + i);
        }
    }
}