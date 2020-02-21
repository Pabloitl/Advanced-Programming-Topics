package MensajeICPC;

import java.awt.Color;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

public class Encripcion {

    public void validateInput(String input) throws Exception {
        String regex = "\\d{2}\\/\\d{2}\\/\\d{4} \\d{2}:\\d{2}:\\d{2}";

        if (input == null || !input.matches(regex))
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

    public void writeMatrix(String binary, JPanel[][] matrix,
            JLabel[][] numbers) {
        writeMatrix(binary, 0, matrix, numbers, 0, 0, matrix.length,
                matrix[0].length);
    }

    public void writeMatrix(String binary, int total, JPanel[][] matrix,
            JLabel[][] numbers, int i, int j, int m, int n) {
        if (i >= m || j >= n) return;

        for (int p = i; p < n; p++)
            personalizePanels(binary, total++, matrix, numbers, i, p);

        for (int p = i + 1; p < m; p++)
            personalizePanels(binary, total++, matrix, numbers, p, n - 1);

        if ((m - 1) != i)
            for (int p = n - 2; p >= j; p--)
                personalizePanels(binary, total++, matrix, numbers, m - 1, p);

        if ((n - 1) != j)
            for (int p = m - 2; p > i; p--)
                personalizePanels(binary, total++, matrix, numbers, p, j);

        writeMatrix(binary, total, matrix, numbers, i + 1, j + 1, m - 1, n - 1);
    }

    private void personalizePanels(String binary, int pos, JPanel[][] matrix,
            JLabel[][] numbers, int i, int j) {
        int color = pos / 4 % 5;
        Color choosedColor;

        switch (pos % 5) {
            case 0: choosedColor = Color.CYAN; break;
            case 1: choosedColor = Color.PINK; break;
            case 2: choosedColor = Color.YELLOW; break;
            case 3: choosedColor = Color.MAGENTA; break;
            default: choosedColor = Color.GREEN; break;
        }
        numbers[i][j].setText(String.valueOf(binary.charAt(pos)));
        matrix[i][j].setBackground(choosedColor);
    }

    public String interpretMatrix(JLabel[][] numbers) {
        String result = "";

        for (int i = 0; i < numbers.length; i++) {
            for (int j = 0; j < numbers[0].length; j++) {
                String rowResult = numbers[i][j].getText();
                result += rowResult;
            }
        }
        return result;
    }

    public void solve(String input, JPanel[][] matrix, JLabel[][] numbers, JLabel answer) {
        try {
            validateInput(input);
            writeMatrix(processInput(input), matrix, numbers);
            answer.setText(interpretMatrix(numbers));
        } catch (Exception ex) {
            JOptionPane.showMessageDialog(null, ex.getMessage());
            System.exit(0);
        }
    }
}
