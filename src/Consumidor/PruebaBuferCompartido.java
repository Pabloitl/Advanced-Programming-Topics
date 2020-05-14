package Consumidor;

// Fig. 23.15: PruebaBuferCompartido.java Aplicación con dos
// subprocesos que manipulan un búfer sin sincronización.

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class PruebaBuferCompartido {
    public static void main(String[] args) {
        // crea nueva reserva de subprocesos con dos subprocesos
        ExecutorService aplicacion = Executors.newCachedThreadPool();

        // crea objeto BuferSinSincronizacion para almacenar valores
        // int
        Bufer ubicacionCompartida = new BuferSinSincronizacion();

        System.out.println("Accion\t\t\tValor\tSuma producidos\tSuma consumidos");
        System.out.println("------\t\t\t-----\t---------------\t---------------\n");

        // ejecuta el Productor y el Consumidor; a cada uno de ellos
        // le proporciona acceso a ubicacionCompartida
        aplicacion.execute(new Productor(ubicacionCompartida));
        aplicacion.execute(new Consumidor(ubicacionCompartida));

        aplicacion.shutdown(); // termina la aplicación cuando se
                               // completan las tareas
    } // fin de main
} // fin de la clase PruebaBuferCompartido
