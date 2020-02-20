package MensajeICPC;

public class PruebaBin {
    public static void main(String[] args) {
        // int a, b;

        // a = 15;
        // b = 1;
        // System.out.println(a & b);
        // System.out.println(a | b);
        // System.out.println(a ^ b);
        ToBin cob = new ToBin(5, 8);
        System.out.println(cob.convierte());
    }
}
