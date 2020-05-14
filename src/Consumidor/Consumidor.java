package Consumidor;

// Fig. 23.13: Consumidor.java Consumidor con un método run que itera
// y lee 10 valores del búfer.
import java.util.Random;

public class Consumidor implements Runnable {
    private final static Random generador = new Random();
    private final Bufer ubicacionCompartida; // referencia al objeto
                                             // compartido

    // constructor
    public Consumidor(Bufer compartido) {
        ubicacionCompartida = compartido;
    } // fin del constructor de Consumidor

    // lee el valor de ubicacionCompartida 10 veces y suma los valores
    public void run() {
        int suma = 0;

        for (int cuenta = 1; cuenta <= 10; cuenta++) {
            // permanece inactivo de 0 a 3 segundos, lee un valor del
            // búfer y lo agrega a suma
            try {
                Thread.sleep(generador.nextInt(3000));
                suma += ubicacionCompartida.obtener();
                System.out.printf("\t\t\t%2d\n", suma);
            } // fin de try si las líneas 26 o 27 se interrumpen,
              // imprime el rastreo de la pila
            catch (InterruptedException excepcion) {
                excepcion.printStackTrace();
            } // fin de catch
        } // fin de for

        System.out.printf("\n%s %d\n%s\n",
                          "Consumidor leyo valores, el total es",
                          suma,
                          "Terminando Consumidor");
    } // fin del método run
} // fin de la clase Consumidor
