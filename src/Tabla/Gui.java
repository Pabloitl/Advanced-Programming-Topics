package Tabla;

import java.awt.Color;
import javax.swing.JFrame;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

public class Gui {
    JFrame window;
    JTable table;
    JScrollPane scroll;
    DefaultTableModel tableModel;
    
    String[] titles = {
        "Nombre del Alumno",
        "Especialidad",
        "Semestre"
    };
    
    String[][] data = {
        {
            "Juan Jose Perez",
            "Sistemas",
            "4"
        },
        {
            "Arturo Robledo",
            "Electromecanica",
            "9"
        },
        {
            "Luis Najera",
            "Losistica",
            "3"
        },
        {
            "Pablo Vargas",
            "Sistemas",
            "4"
        },
        {
            "Rebeca Valadez",
            "Logistica",
            "2"
        },
        {
            "Pastrano Mesa",
            "Electromecanica",
            "1"
        },
        {
            "Juan Jose Perez",
            "Sistemas",
            "4"
        },
        {
            "Arturo Robledo",
            "Electromecanica",
            "9"
        },
        {
            "Luis Najera",
            "Losistica",
            "3"
        },
        {
            "Pablo Vargas",
            "Sistemas",
            "4"
        },
        {
            "Rebeca Valadez",
            "Logistica",
            "2"
        },
        {
            "Pastrano Mesa",
            "Electromecanica",
            "1"
        }
    };
    
    public Gui() {
        window = new JFrame();
        tableModel = new DefaultTableModel(data, titles);
        table  = new JTable(tableModel);
        scroll = new JScrollPane(table);
        
        this.atributos();
        this.armado();
        this.escuchas();
        this.lanzar_GUI();
    }

    public void atributos() {
        window.setSize(350, 200);
        window.setResizable(true);
        table.setBackground(Color.YELLOW);
        table.setSelectionBackground(Color.PINK);
        table.setAutoCreateRowSorter(true);
        tableModel.addColumn("Nueva Columna");
        tableModel.addRow(new String[] {
            "Jasiel",
            "IGE",
            "1",
            "qwerty"
        });
    }

    public void armado() {
        window.add(scroll);
    }

    public void escuchas() {
    }

    public void lanzar_GUI() {
        window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        window.setLocationRelativeTo(null);
        window.setVisible(true);
        tableModel.addColumn("Nueva Columna");
        tableModel.addRow(new String[] {
            "Jasiel",
            "IGE",
            "1",
            "qwerty"
        });
    }
}