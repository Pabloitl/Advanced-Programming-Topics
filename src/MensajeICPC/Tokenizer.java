package MensajeICPC;

import java.util.StringTokenizer;

public class Tokenizer {
    /**
     * Ejemplo para validar y limpiar la fecha utilizando
     * StringTokenizer u otras alternativas vistas en clase
     * @param args 
     */
    public static void main(String[] args) {
        String meeting = "02/14/2020 11:30:35";
        StringTokenizer st = new StringTokenizer(meeting, " /-:");
        
        // Con StringTokenizer
        // while (st.hasMoreTokens())
            // System.out.println(st.nextToken());
        
        // Con replaceAll
        meeting = meeting.replaceAll("\\s|/|:", "");
        System.out.println(meeting);
    }
}
