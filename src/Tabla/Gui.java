package Tabla;

import java.awt.BorderLayout;
import java.awt.Color;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextArea;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;
import javax.swing.table.DefaultTableModel;

public class Gui {
    JFrame window;
    JTable table;
    JTextArea infoLabel;
    JScrollPane scroll;
    DefaultTableModel tableModel;

    public Gui() {
        window     = new JFrame();
        infoLabel  = new JTextArea();
        tableModel = new DefaultTableModel(Data.data, Data.titles);
        table      = new JTable(tableModel);
        scroll     = new JScrollPane(table);

        this.atributos();
        this.armado();
        this.escuchas();
        this.lanzar_GUI();
    }

    public void atributos() {
        window.setSize(500, 350);
        window.setResizable(true);
        window.setLayout(new BorderLayout());
        table.setBackground(Color.CYAN);
        table.setSelectionBackground(Color.PINK);
        table.setAutoCreateRowSorter(true);
    }

    public void armado() {
        window.add(scroll, BorderLayout.CENTER);
        window.add(infoLabel, BorderLayout.SOUTH);
    }

    public void escuchas() {
        table.getSelectionModel().addListSelectionListener(new Listener());
    }

    public void lanzar_GUI() {
        window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        window.setLocationRelativeTo(null);
        window.setVisible(true);
    }

    private class Listener implements ListSelectionListener {
        @Override
        public void valueChanged(ListSelectionEvent lse) {
            int row = table.getSelectedRow();
            StringBuilder textBuilder = new StringBuilder();

            for (int i = 0; i < table.getColumnCount(); i++)
                textBuilder
                    .append(table.getColumnName(i))
                    .append(": ")
                    .append(table.getValueAt(row, i))
                    .append("\n");
            infoLabel.setText(textBuilder.toString());
        }
    }
}
