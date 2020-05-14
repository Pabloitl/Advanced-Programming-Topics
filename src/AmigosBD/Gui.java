package AmigosBD;

import java.awt.BorderLayout;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.util.HashMap;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;

public class Gui {
    JFrame window;
    DefaultTableModel tableModel;
    JTable tableJTable;
    JScrollPane tableScroll;
    JLabel basesLabel, consultaLabel;
    JComboBox<String> basesBox;
    JTextField consultaField;
    JButton aceptarButton;
    JPanel formPanel;
    
    String[] urls;

    public Gui(HashMap<String, String> bases) {
        window = new JFrame("Conexión a base de datos");
        formPanel = new JPanel();
        tableModel = new DefaultTableModel();
        tableJTable = new JTable(tableModel);
        tableScroll = new JScrollPane(tableJTable);
        basesLabel = new JLabel("Bases de Datos: ");
        consultaLabel = new JLabel("Consulta SQL: ");
        basesBox = new JComboBox(bases.keySet().toArray());
        urls = bases.values().toArray(new String[] {});
        consultaField = new JTextField("SELECT * FROM COLLEAGUES;");
        aceptarButton = new JButton("Aceptar");

        this.configurar();
        this.armar();
        this.escuchas();
        this.lanzarGui();
    }

    private void configurar() {
        formPanel.setLayout(new GridBagLayout());
        consultaField.setScrollOffset(5);
        window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }

    private void armar() {
        GridBagConstraints gc = new GridBagConstraints();
        
        gc.fill = GridBagConstraints.HORIZONTAL;
        gc.weightx = 1;
        gc.anchor = GridBagConstraints.EAST;
        formPanel.add(basesLabel, gc);
        gc.anchor = GridBagConstraints.WEST;
        gc.gridx = 1;
        formPanel.add(basesBox);
        gc.gridx = 2;
        formPanel.add(aceptarButton);
        gc.gridx = 1;
        gc.gridy = 1;
        gc.gridwidth = 2;
        formPanel.add(consultaField, gc);
        gc.gridx = 0;
        gc.gridwidth = 1;
        gc.anchor = GridBagConstraints.EAST;
        formPanel.add(consultaLabel, gc);
        window.add(formPanel, BorderLayout.NORTH);
        window.add(tableScroll, BorderLayout.CENTER);
    }
    
    private void escuchas() {
        aceptarButton.addMouseListener(new EscuchaBoton());
        consultaField.addKeyListener(new EscuchaTextField());
    }

    private void lanzarGui() {
        window.setVisible(true);
    }
        
    private void cargarDatos() {
        DataBase db = new DataBase(urls[basesBox.getSelectedIndex()],
                consultaField.getText(),
                "virtual", "virtual");

        tableModel.setDataVector(db.getDatos(), db.getEncabezados());
    }
    
    private class EscuchaBoton implements MouseListener {
        @Override
        public void mouseClicked(MouseEvent me) {
            if (me.getSource() == aceptarButton)
                cargarDatos();
        }

        @Override
        public void mousePressed(MouseEvent me) {
        }

        @Override
        public void mouseReleased(MouseEvent me) {
        }

        @Override
        public void mouseEntered(MouseEvent me) {
        }

        @Override
        public void mouseExited(MouseEvent me) {
        }
    }
    
    private class EscuchaTextField implements KeyListener {
        @Override
        public void keyTyped(KeyEvent ke) {
            if (ke.getKeyChar() == '\n')
                cargarDatos();
        }

        @Override
        public void keyPressed(KeyEvent ke) {
        }

        @Override
        public void keyReleased(KeyEvent ke) {
        }
    }
}
