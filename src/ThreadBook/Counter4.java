package ThreadBook;

//: c14:Counter4.java
// By keeping your thread as a distinct class,
// you can have as many threads as you want.
// <applet code=Counter4 width=200 height=600>
// <param name=size value="12"></applet>

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class Counter4 extends JApplet {
    private JButton start = new JButton("Start");
    private boolean started = false;
    private Ticker[] s;
    private boolean isApplet = true;
    private int size = 12;

    class Ticker extends Thread {
        private JButton b = new JButton("Toggle");
        private JTextField t = new JTextField(10);
        private int count = 0;
        private boolean runFlag = true;

        public Ticker() {
            b.addActionListener(new ToggleL());
            JPanel p = new JPanel();
            p.add(t);
            p.add(b);
            // Calls JApplet.getContentPane().add():
            getContentPane().add(p);
        }

        class ToggleL implements ActionListener {
            public void actionPerformed(ActionEvent e) {
                runFlag = !runFlag;
            }
        }

        public void run() {
            while (true) {
                if (runFlag)
                    t.setText(Integer.toString(count++));
                try {
                    sleep(100);
                } catch (InterruptedException e) {
                    System.err.println("Interrupted");
                }
            }
        }
    }

    class StartL implements ActionListener {
        public void actionPerformed(ActionEvent e) {
            if (!started) {
                started = true;
                for (int i = 0; i < s.length; i++)
                    s[i].start();
            }
        }
    }

    public void init() {
        Container cp = getContentPane();
        cp.setLayout(new FlowLayout());
        // Obtiene los parametros "size" de la página Web:
        if (isApplet) {
            String sz = getParameter("size");
            if (sz != null)
                size = Integer.parseInt(sz);
        }
        s = new Ticker[size];
        for (int i = 0; i < s.length; i++)
            s[i] = new Ticker();
        start.addActionListener(new StartL());
        cp.add(start);
    }

    public static void main(String[] args) {
        Counter4 applet = new Counter4();
        // No es un applet, así es que configuramos la bandera y
        // producimos los valores de parametros de los argumentos:
        applet.isApplet = false;
        if (args.length != 0)
            applet.size = Integer.parseInt(args[0]);
        Console.run(applet, 200, applet.size * 50);
    }
} /// :~
