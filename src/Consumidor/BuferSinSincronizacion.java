package Consumidor;

// Fig. 23.14: BuferSinSincronizacion.java BuferSinSincronizacion
// mantiene el entero compartido que utilizan los subprocesos
// productor y consumidor mediante los métodos establecer y obtener.

public class BuferSinSincronizacion implements Bufer {
    private int bufer = -1; // compartido por los subprocesos
                            // productor y consumidor

    // coloca el valor en el búfer
    public void establecer(int valor) throws InterruptedException {
        System.out.printf("Productor escribe\t%2d", valor);
        bufer = valor;
    } // fin del método establecer

    // devuelve el valor del búfer
    public int obtener() throws InterruptedException {
        System.out.printf("Consumidor lee\t\t%2d", bufer);
        return bufer;
    } // fin del método obtener
} // fin de la clase BuferSinSincronizacion
