package Barbero;

public class BarberoDurmiente {

    public static void main(String[] args) {
        Barbero barbero = new Barbero(false);
        int n = 15; // Número de clientes

        for (int i = 0; i < n; i++) {
            Cliente c = new Cliente(i + 1, barbero);
            c.start();
        }
    }
}

class Barbero {
    public boolean ocupado;
    public boolean[] sillas = new boolean[5];

    public Barbero(boolean ocupado) {
        this.ocupado = ocupado;
    }

    public synchronized void ocuparSilla(int numClie) {
        System.out.println("Silla ocupada por el cliente número: " + numClie);
    }

    public synchronized void dejarSilla(int numClie) {
        while (isOcupado()) {
            try {
                wait();
            } catch (InterruptedException ex) {
                ex.printStackTrace();
            }
        }
        System.out.println("El cliente " + numClie + " deja libre una silla");
    }

    public synchronized void inicioCorte(int numClie) {
        while (isOcupado()) {
            System.out.println("Barbero ocupado, " + numClie + " espera");
            try {
                wait();
            } catch (InterruptedException ex) {
                ex.printStackTrace();
            }
        }
        this.setOcupado(true);
        System.out.println("El barbero empieza a cortar el pelo al cliente "
                           + numClie);
    }

    public synchronized void finCorte(int numClie) {
        this.setOcupado(false);
        System.out.println("El barbero termina de cortar el pelo al cliente "
                           + numClie);
        notify();
    }

    public boolean isOcupado() {
        return ocupado;
    }

    public void setOcupado(boolean ocupado) {
        this.ocupado = ocupado;
    }
}


class Cliente extends Thread {
    private Barbero bar;
    private int numCliente;

    public Cliente(int nCli, Barbero b) {
        this.numCliente = nCli;
        this.bar = b;
    }

    @Override
    public void run() {
        try {
            bar.inicioCorte(numCliente);
            sleep(800);
            bar.finCorte(numCliente);
        } catch (InterruptedException ex) {
            ex.printStackTrace();
        }
    }
}
