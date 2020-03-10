package Covid;

import java.awt.BorderLayout;
import java.awt.Font;
import java.util.Arrays;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.ListSelectionModel;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.DefaultTableModel;

public class Covid {
    JFrame window;
    JPanel leftPanel;
    JList filesList;
    JTable dataTable;
    DefaultTableModel dataTableModel;
    DefaultTableCellRenderer dataRenderer;
    JScrollPane filesScroll, tableScroll;
    JLabel fileLabel;
    String[] fileNames;

    public Covid() {
        fileNames = DataBuilder.listFileNames(DataBuilder.DIR);
        String[][] data =
                DataBuilder.processFile(
                        DataBuilder.DIR + fileNames[0] + ".csv");
        window = new JFrame();
        leftPanel = new JPanel();
        filesList = new JList(fileNames);
        dataTableModel = new DefaultTableModel(
                Arrays.copyOfRange(data, 1, data.length), data[0]);
        dataTable = new JTable(dataTableModel);
        filesScroll = new JScrollPane(filesList);
        tableScroll = new JScrollPane(dataTable);
        fileLabel = new JLabel();
        dataRenderer = new DefaultTableCellRenderer();
        dataTableModel.addRow(DataBuilder.getSumRow(data, new int[] { 3, 4, 5 }));


        this.atributos();
        this.armado();
        this.escuchas();
        this.lanzar_GUI();
    }

    public void atributos() {
        window.setSize(700, 400);
        window.setResizable(true);
        window.setLayout(new BorderLayout());
        window.setTitle("COVID-19");
        leftPanel.setLayout(new BorderLayout());
        filesList.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
        filesList.setSelectedIndex(0);
        filesList.setFont(new Font("Arial", Font.ITALIC, 14));
        fileLabel.setText(filesList.getSelectedValue().toString());
        fileLabel.setFont(new Font("Arial", Font.BOLD, 20));
        fileLabel.setHorizontalAlignment(JLabel.CENTER);
        dataRenderer.setHorizontalAlignment(DefaultTableCellRenderer.CENTER);
        dataTable.getColumnModel().getColumn(3).setCellRenderer(dataRenderer);
        dataTable.getColumnModel().getColumn(4).setCellRenderer(dataRenderer);
        dataTable.getColumnModel().getColumn(5).setCellRenderer(dataRenderer);
    }

    public void armado() {
        leftPanel.add(filesScroll, BorderLayout.CENTER);
        window.add(leftPanel, BorderLayout.WEST);
        window.add(fileLabel, BorderLayout.NORTH);
        window.add(tableScroll, BorderLayout.CENTER);
    }

    public void escuchas() {
        filesList.addListSelectionListener(new MyListListener());
    }

    public void lanzar_GUI() {
        window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        window.setLocationRelativeTo(null);
        window.setVisible(true);
    }

    class MyListListener implements ListSelectionListener {
        @Override
        public void valueChanged(ListSelectionEvent lse) {
            if (lse.getValueIsAdjusting())
                return;

            String newFile = filesList.getSelectedValue().toString();
            String[][] data
                    = DataBuilder.processFile(
                            DataBuilder.DIR + newFile + ".csv");
            fileLabel.setText(newFile);
            dataTableModel.setRowCount(0);
            for (int i = 1; i < data.length; i++)
                    dataTableModel.addRow(data[i]);
            dataTableModel.addRow(DataBuilder.getSumRow(data, new int[] { 3, 4, 5 }));
        }
    }
}
