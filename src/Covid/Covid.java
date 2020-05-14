package Covid;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.Font;
import java.util.Arrays;
import javax.swing.BoxLayout;
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
    JPanel leftPanel, centerPanel;
    JList filesList;
    JTable dataTable, countryTable, sumsTable;
    DefaultTableModel dataTableModel, countryTableModel, sumsTableModel;
    DefaultTableCellRenderer dataRenderer;
    JScrollPane filesScroll, tableScroll, countryScroll, sumsScroll;
    JLabel fileLabel;
    String[] fileNames;

    public Covid() {
        fileNames = DataBuilder.listFileNames(DataBuilder.DIR);
        String[][] data =
                DataBuilder.processFile(
                        DataBuilder.DIR + fileNames[0] + ".csv");
        dataTableModel = new DefaultTableModel(
                Arrays.copyOfRange(data, 1, data.length), data[0]);
        countryTableModel = new DefaultTableModel(
            DataBuilder.countrySums(data),
            new String[] {
                "Country",
                "Confirmed"
            }
        );
        sumsTableModel = new DefaultTableModel(
            DataBuilder.sums(data),
            new String[] {
                "Country",
                "Confirmed",
                "Deaths",
                "Recovered"
            });
        window = new JFrame();
        leftPanel = new JPanel();
        centerPanel = new JPanel();
        filesList = new JList(fileNames);
        dataTable = new JTable(dataTableModel);
        sumsTable = new JTable(sumsTableModel);
        countryTable = new JTable(countryTableModel);
        filesScroll = new JScrollPane(filesList);
        tableScroll = new JScrollPane(dataTable);
        countryScroll = new JScrollPane(countryTable);
        sumsScroll = new JScrollPane(sumsTable);
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
        leftPanel.setLayout(new BoxLayout(leftPanel, BoxLayout.Y_AXIS));
        leftPanel.setPreferredSize(new Dimension(150, 100));
        centerPanel.setLayout(new BoxLayout(centerPanel, BoxLayout.Y_AXIS));
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
        leftPanel.add(filesScroll);
        leftPanel.add(countryScroll);
        window.add(leftPanel, BorderLayout.WEST);
        window.add(fileLabel, BorderLayout.NORTH);
        centerPanel.add(tableScroll);
        centerPanel.add(sumsScroll);
        window.add(centerPanel, BorderLayout.CENTER);

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

            countryTableModel.setRowCount(0);
            for (String[] countrySum : DataBuilder.countrySums(data))
                countryTableModel.addRow(countrySum);

            sumsTableModel.setRowCount(0);
            for (String[] sum: DataBuilder.sums(data))
                sumsTableModel.addRow(sum);
        }
    }
}
