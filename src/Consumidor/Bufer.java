package Consumidor;

// Fig. 23.11: Bufer.java La interfaz Bufer especifica los métodos que
//el Productor y el Consumidor llaman.

public interface Bufer {
    // coloca valor int value en Bufer
    public void establecer(int valor) throws InterruptedException;

    // obtiene valor int de Bufer
    public int obtener() throws InterruptedException;
} // fin de la interfaz Bufer
