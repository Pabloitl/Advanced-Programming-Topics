package Covid;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;

import javax.swing.JOptionPane;

public class DataBuilder {
    public static final String DIR = "src/Covid/Data/", SEP = ",";

    private static String[] processLine(String line) {
        int i = 0;
        String[] tokens = line.split(SEP);
        ArrayList<String> newTokens = new ArrayList();

        if (tokens[i].contains("\""))
            newTokens.add((tokens[i++] + ", " + tokens[i++]).replace("\"", ""));
        else
            newTokens.add(tokens[i++]);
        for (; i < tokens.length; i++)
            newTokens.add(tokens[i]);

        return newTokens.toArray(new String[newTokens.size()]);
    }

    public static String[][] processFile(String file) {
        BufferedReader in = null;
        ArrayList<String[]> linesArray = new ArrayList();

        try {
            in = new BufferedReader(new FileReader(file));
            String line;

            while ((line = in.readLine()) != null)
                linesArray.add(processLine(line));
        } catch (Exception ex) {
            JOptionPane.showMessageDialog(null, ex.getMessage());
        } finally {
            try {
                in.close();
            } catch (IOException ex) {
                JOptionPane.showMessageDialog(null, ex.getMessage());
            }
        }

        return linesArray.toArray(new String[][] {});
    }

    public static String[] listFileNames(String dir) {
        return listFileNames(new File(dir));
    }

    public static String[] listFileNames(File dir) {
        String[] files = dir.list();

        for (int i = 0; i < files.length; i++)
            files[i] = files[i].substring(0, files[i].length() - 4);
        return files;
    }

    public static int sumColumn(String[][] arr, int column) {
        int sum = 0;

        for (int i = 0; i < arr.length; i++)
            try {
                sum += Integer.parseInt(arr[i][column]);
            } catch (Exception e) {

            }
        return sum;
    }

    public static String[] getSumRow(String[][] arr, int[] columns) {
        String[] results = new String[max(columns) + 1];

        results[0] = "Total";
        for (int column : columns)
            results[column] = String.valueOf(sumColumn(arr, column));
        return results;
    }
    
    private static int max(int[] arr) {
        int max = Integer.MIN_VALUE;
        
        for (int i : arr)
            if (i > max) max = i;
        return max;
    }
}
