package Executor;

// Fig. 23.6: EjecutorTareas.java Uso de un objeto ExecutorService
// para ejecutar objetos Runnable.

import java.util.concurrent.Executors;
import java.util.concurrent.ExecutorService;

public class ExecutorSingle {
    public static void main(String[] args) {
        // crea y nombra cada objeto Runnable
        TareaImprimir tarea1 = new TareaImprimir("tarea1");
        TareaImprimir tarea2 = new TareaImprimir("tarea2");
        TareaImprimir tarea3 = new TareaImprimir("tarea3");
        TareaImprimir tarea4 = new TareaImprimir("tarea4");

        System.out.println("Iniciando Executor");

        // crea objeto ExecutorService para administrar los subprocesos
        ExecutorService ejecutorSubprocesos = Executors.newSingleThreadExecutor();

        // inicia los subprocesos y los coloca en el estado ejecutable
        ejecutorSubprocesos.execute(tarea1); // inicia tarea1
        ejecutorSubprocesos.execute(tarea2); // inicia tarea2
        ejecutorSubprocesos.execute(tarea3); // inicia tarea3
        ejecutorSubprocesos.execute(tarea4); // inicia tarea4
        // cierra los subprocesos trabajadores cuando terminan sus
        // tareas
        ejecutorSubprocesos.shutdown();

        System.out.println("Tareas iniciadas, main termina.\n");
    } // fin de main
} // fin de la clase EjecutorTareas
