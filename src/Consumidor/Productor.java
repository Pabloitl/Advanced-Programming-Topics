package Consumidor;

// Fig. 23.12: Productor.java Productor con un método run que inserta
// los valores del 1 al 10 en el búfer.

import java.util.Random;

public class Productor implements Runnable {
    private final static Random generador = new Random();
    private final Bufer ubicacionCompartida; // referencia al objeto
                                             // compartido

    // constructor
    public Productor(Bufer compartido) {
        ubicacionCompartida = compartido;
    } // fin del constructor de Productor

    // almacena valores del 1 al 10 en ubicacionCompartida
    public void run() {
        int suma = 0;

        for (int cuenta = 1; cuenta <= 10; cuenta++) {
            try // permanece inactivo de 0 a 3 segundos, después
                // coloca valor en Bufer
            {
                Thread.sleep(generador.nextInt(3000)); // periodo de
                                                       // inactividad
                                                       // aleatorio
                ubicacionCompartida.establecer(cuenta); // establece
                                                        // el valor en
                                                        // el búfer
                suma += cuenta; // incrementa la suma de los valores
                System.out.printf("\t%2d\n", suma);
            } // fin de try si las líneas 25 o 26 se interrumpen,
              // imprime el rastreo de la pila
            catch (InterruptedException excepcion) {
                excepcion.printStackTrace();
            } // fin de catch
        } // fin de for

        System.out.println("Productor termino de producir\n"
                           + "Terminando Productor");
    } // fin del método run
} // fin de la clase Productor
