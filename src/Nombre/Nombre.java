package Nombre;

import java.util.Random;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.atomic.AtomicInteger;

public class Nombre {
    private final int
        REPETITIONS = 10,
        DELAY = 1000, // milisegundos
        NUM_TIPOS = 5,
        NUM_TIP1 = 1,
        NUM_TIP2 = 2,
        NUM_TIP3 = 4,
        NUM_TIP4 = 5,
        NUM_TIP5 = 8,
        TOTAL_NUM = NUM_TIP1 + NUM_TIP2 + NUM_TIP3 + NUM_TIP4 + NUM_TIP5;

    private AtomicInteger turno;
    
    public Nombre() {
        turno = new AtomicInteger(0);
    }

    public void imprimirNombre() {
        ExecutorService pool = Executors.newFixedThreadPool(TOTAL_NUM);

        for (int i = 0; i < NUM_TIP1; i++)
            pool.submit(new Tipo1());
        for (int i = 0; i < NUM_TIP2; i++)
            pool.submit(new Tipo2());
        for (int i = 0; i < NUM_TIP3; i++)
            pool.submit(new Tipo3());
        for (int i = 0; i < NUM_TIP4; i++)
            pool.submit(new Tipo4());
        for (int i = 0; i < NUM_TIP5; i++)
            pool.submit(new Tipo5());
        
        pool.shutdown();
    }
    
    private abstract class PrintThread implements Runnable {
        protected void printIfTurn(int turn, String msg, int space) {
            synchronized (turno) {
                if (turno.get() % NUM_TIPOS != turn) return;
                if (turno.get() >= REPETITIONS * NUM_TIPOS) return;
                
                System.out.printf("%" + space + "s", msg);
                turno.addAndGet(1);
            }
        }
        
        protected void timeUp(int turn) {
            while (turno.get() % 5 != turn) {
                try {
                    Thread.sleep(new Random().nextInt(DELAY / 2) + DELAY / 2);
                    if (turno.get() >= REPETITIONS * NUM_TIPOS)
                        Thread.currentThread().stop();
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        }
    }

    private class Tipo1 extends PrintThread {
        @Override
        public void run() {
            int turn = 0;
            
            while (turno.get() < REPETITIONS * NUM_TIPOS) {
                timeUp(turn);
                printIfTurn(turn, String.valueOf(turno.get() / 5 + 1), 4);
            }
        }
    }

    private class Tipo2 extends PrintThread {
        @Override
        public void run() {
            int turn = 1;
            
            while (turno.get() < REPETITIONS * TOTAL_NUM) {
                timeUp(turn);
                printIfTurn(turn, "Pablo", 7);
            }
        }
    }

    private class Tipo3 extends PrintThread {
        @Override
        public void run() {
            int turn = 2;
            
            while (turno.get() < REPETITIONS * TOTAL_NUM) {
                timeUp(turn);
                printIfTurn(turn, "(Sin)", 7);
            }
        }
    }

    private class Tipo4 extends PrintThread {
        @Override
        public void run() {
            int turn = 3;
            
            while (turno.get() < REPETITIONS * TOTAL_NUM) {
                timeUp(turn);
                printIfTurn(turn, "Vargas", 8);
            }
        }
    }

    private class Tipo5 extends PrintThread {
        @Override
        public void run() {
            int turn = 4;
            
            while (turno.get() < REPETITIONS * TOTAL_NUM) {
                timeUp(turn);
                printIfTurn(turn, "Bermúdez\n", 11);
            }
        }
    }
}
