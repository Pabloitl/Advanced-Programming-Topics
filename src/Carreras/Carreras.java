package Carreras;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.BoxLayout;
import javax.swing.ButtonGroup;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JRadioButton;

public class Carreras {
    JFrame window;
    JLabel turnoLabel;
    JLabel carreraLabel;
    JPanel turnosPanel;
    JPanel carrerasPanel;
    ButtonGroup turnosGroup;
    ButtonGroup carrerasGroup;
    JRadioButton[] turnosRadioButtons;
    JRadioButton[] carrerasRadioButtons;

    public Carreras(String[] nombresCarreras, String[] nombresTurnos) {
        window               = new JFrame();
        turnoLabel           = new JLabel();
        carreraLabel         = new JLabel();
        turnosPanel          = new JPanel();
        carrerasPanel        = new JPanel();
        turnosGroup          = new ButtonGroup();
        carrerasGroup        = new ButtonGroup();
        turnosRadioButtons   = new JRadioButton[nombresTurnos.length];
        carrerasRadioButtons = new JRadioButton[nombresCarreras.length];

        for(int i = 0; i < nombresCarreras.length; i++)
            carrerasRadioButtons[i] = new JRadioButton(nombresCarreras[i]);
        for (int i = 0; i < nombresTurnos.length; i++)
            turnosRadioButtons[i] = new JRadioButton(nombresTurnos[i]);

        this.atributos();
        this.armado();
        this.escuchas();
        this.lanzar_GUI();
    }

    public void atributos() {
        Color slateColor = new Color(240, 128, 128);

        window.setSize(500, 300);
        window.setResizable(true);
        window.setLayout(new BorderLayout());
        turnoLabel.setFont(new Font("Comic Sans", Font.ITALIC, 20));
        turnoLabel.setHorizontalAlignment(JLabel.CENTER);
        turnoLabel.setBackground(slateColor);
        turnoLabel.setOpaque(true);
        carreraLabel.setFont(new Font("Comic Sans", Font.ITALIC, 20));
        carreraLabel.setHorizontalAlignment(JLabel.CENTER);
        carreraLabel.setBackground(slateColor);
        carreraLabel.setOpaque(true);
        carrerasPanel.setLayout(new BoxLayout(carrerasPanel, BoxLayout.Y_AXIS));
        carrerasPanel.setBackground(slateColor);
        turnosPanel.setLayout(new BoxLayout(turnosPanel, BoxLayout.Y_AXIS));
        turnosPanel.setBackground(slateColor);
        for (JRadioButton btn : carrerasRadioButtons) {
            btn.setActionCommand(btn.getText());
            btn.setBackground(slateColor);
        }
        for(JRadioButton btn : turnosRadioButtons) {
            btn.setActionCommand(btn.getText());
            btn.setBackground(slateColor);
        }
    }

    public void armado() {
        window.add(carreraLabel, BorderLayout.CENTER);
        window.add(turnoLabel, BorderLayout.NORTH);
        carrerasPanel.add(new JLabel("Carreras"));
        for(JRadioButton btn : carrerasRadioButtons) {
            carrerasGroup.add(btn);
            carrerasPanel.add(btn);
        }
        turnosPanel.add(new JLabel("Turnos"));
        for (JRadioButton btn : turnosRadioButtons) {
            turnosGroup.add(btn);
            turnosPanel.add(btn);
        }
        window.add(carrerasPanel, BorderLayout.WEST);
        window.add(turnosPanel, BorderLayout.EAST);
    }

    public void escuchas() {
        for (JRadioButton btn : carrerasRadioButtons)
            btn.addActionListener(new Listener("Carrera"));
        for (JRadioButton btn : turnosRadioButtons)
            btn.addActionListener(new Listener("Turno"));
    }

    public void lanzar_GUI() {
        window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        window.setLocationRelativeTo(null);
        window.setVisible(true);
    }

    class Listener implements ActionListener {
        boolean carreraFlag;

        public Listener(String tipo) {
            if (tipo.toLowerCase().equals("carrera"))
                carreraFlag = true;
        }

        @Override
        public void actionPerformed(ActionEvent ae) {
            if(carreraFlag)
                carreraLabel.setText(ae.getActionCommand());
            else
                turnoLabel.setText(ae.getActionCommand());
        }
    }
}
