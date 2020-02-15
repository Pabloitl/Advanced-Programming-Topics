package MensajeICPC;

import java.awt.Color;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

public class Encripcion {

    public void validateInput(String input) throws Exception {
        String regex = "\\d{2}\\/\\d{2}\\/\\d{4} \\d{2}:\\d{2}:\\d{2}";

        if (!input.matches(regex))
            throw new Exception("Invalid Input");
    }

    public String processInput(String input) {
        String extra = "[\\s/:]";
        input = input.replaceAll(extra, "");
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

    public void writeMatrix(String binary, JPanel[][] matrix) {
        writeMatrix(binary, 0, matrix, 0, 0, matrix.length, matrix[0].length);
    }

    public void writeMatrix(String binary, int total, JPanel[][] matrix, int i,
            int j, int m, int n) {
        if (i >= m || j >= n) return;

        for (int p = i; p < n; p++)
            changeColor(binary, total++, matrix, i, p);

        for (int p = i + 1; p < m; p++)
            changeColor(binary, total++, matrix, p, n - 1);

        if ((m - 1) != i)
            for (int p = n - 2; p >= j; p--)
                changeColor(binary, total++, matrix, m - 1, p);

        if ((n - 1) != j)
            for (int p = m - 2; p > i; p--)
                changeColor(binary, total++, matrix, p, j);
        
        writeMatrix(binary, total, matrix, i + 1, j + 1, m - 1, n - 1);
    }
    
    private void changeColor(String binary, int pos, JPanel[][] matrix, int i,
            int j) {
        matrix[i][j].setBackground(
                        (binary.charAt(pos) == '1')
                        ? Color.WHITE
                        : Color.BLACK);
    }

    public String[] interpretMatrix(JPanel[][] matrix) {
        String[] result = new String[matrix.length];

        for (int i = 0; i < matrix.length; i++) {
            String rowResult = "";

            for (int j = 0; j < matrix[0].length; j++) {
                rowResult += (matrix[i][j].getBackground().equals(Color.WHITE)
                        ? "1"
                        : "0");
            }
            result[i] = String.valueOf(Integer.parseInt(rowResult, 2));
        }
        return result;
    }
    
    public void writeAnswers(String[] answer, JLabel[] text) {
        for (int i = 0; i < answer.length; i++)
            text[i].setText(answer[i]);
    }

    public String solve(String input, JPanel[][] matrix, JLabel[] text) {
        String result = "";
        try {
            validateInput(input);
            writeMatrix(processInput(input), matrix);
            writeAnswers(interpretMatrix(matrix), text);
        } catch (Exception ex) {
            JOptionPane.showMessageDialog(null, ex.getMessage());
            System.exit(1);
        }
        return result;
    }
}
