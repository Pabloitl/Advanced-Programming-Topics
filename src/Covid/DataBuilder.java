package Covid;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.Set;

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
    
    public static String[][] countrySums(String[][] arr) {
        HashMap<String, Integer> result = new HashMap();
        
        for (String[] strings : arr) {
            try {
                if (result.containsKey(strings[1]))
                    result.put(strings[1],
                            result.get(strings[1])
                                    + Integer.parseInt(strings[3]));
                else
                    result.put(strings[1], Integer.parseInt(strings[3]));
            } catch (Exception e) {
            }
        }
        return transform(result);
    }
    
    private static String[][] transform(HashMap<String, Integer> h) {
        ArrayList<String[]> result = new ArrayList();
        
        for (String string : h.keySet())
            result.add(new String[] {string, String.valueOf(h.get(string))});
        
        return result.toArray(new String[][] {});
    }
}
