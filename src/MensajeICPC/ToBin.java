package MensajeICPC;

/**
 * Clase hecha para transformar a binario
 * Por el profesor
 */
public class ToBin {
    private int valor;
    private int n_bits;

    public ToBin(int valor, int n_bits) {
        this.valor = valor;
        this.n_bits = n_bits;
    }

    public String convierte() {
        int copia = valor;
        String cadbin = "";
        int mask = 1;

        for (int i = 0; i < n_bits; i++) {
            cadbin = cadbin + (copia & mask);
            copia >>= 1;
        }

        String nuevo = "";
        for (int ultimo = cadbin.length() - 1; ultimo >= 0; ultimo--) {
            nuevo = nuevo + cadbin.charAt(ultimo);
        }
        return nuevo;
    }

    private String to_bin(int copia, int n_bits) {
        String st = "";
        if(n_bits > 0)
            st = to_bin(copia >> 1, n_bits - 1) + (copia & 1);
        return st;
    }
}
