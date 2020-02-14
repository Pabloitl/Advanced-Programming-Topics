package MensajeICPC;

import java.awt.Color;
import javax.swing.JPanel;

public class Encripcion {

    public void validateInput(String input) throws Exception {
        String regex = "\\d{2}\\/\\d{2}\\/\\d{2} \\d{2}:\\d{2}:\\d{2}";

        if (!input.matches(regex)) {
            throw new Exception("Invalid Input");
        }
    }

    public String proccesInput(String input) {
        String[] extra = {"/", ":", " "};

        for (String c : extra) {
            input = input.replaceAll(c, "");
        }
        return toBinary(input);
    }

    private String toBinary(String input) {
        String result = "";

        for (int i = 0; i < input.length(); ++i) {
            int temp = Integer.parseInt(String.valueOf(input.charAt(i)));
            String bin = Integer.toBinaryString(temp);
            bin = String.format("%04d", Integer.parseInt(bin));
            result += bin;
        }
        return result;
    }

    public void writeMatrix(String binary, JPanel[][] arr) {
        int i = 0, j = 0, m = arr.length, n = arr[0].length;
        writeMatrix(binary, 0, arr, i, j, m, n);
    }

    public void writeMatrix(String binary, int total, JPanel[][] arr, int i,
            int j, int m, int n) {
        if (i >= m || j >= n) {
            return;
        }

        for (int p = i; p < n; p++) {
            arr[i][p].setBackground(
                    (binary.charAt(total++) == '1')
                    ? Color.WHITE
                    : Color.BLACK);
        }

        for (int p = i + 1; p < m; p++) {
            arr[p][n - 1].setBackground(
                    (binary.charAt(total++) == '1')
                    ? Color.WHITE
                    : Color.BLACK);
        }

        if ((m - 1) != i) {
            for (int p = n - 2; p >= j; p--) {
                arr[m - 1][p].setBackground(
                        (binary.charAt(total++) == '1')
                        ? Color.WHITE
                        : Color.BLACK);
            }
        }

        if ((n - 1) != j) {
            for (int p = m - 2; p > i; p--) {
                arr[p][j].setBackground(
                        (binary.charAt(total++) == '1')
                        ? Color.WHITE
                        : Color.BLACK);
            }
        }
        writeMatrix(binary, total, arr, i + 1, j + 1, m - 1, n - 1);
    }

    public String interpretMatrix(JPanel[][] matrix) {
        String result = "";

        for (int i = 0; i < matrix.length; i++) {
            String rowResult = "";

            for (int j = 0; j < matrix[0].length; j++) {
                rowResult += (matrix[i][j].getBackground().equals(Color.BLACK)
                        ? "1"
                        : "0");
            }
            result += Integer.parseInt(rowResult, 2);
        }
        return result;
    }
}
