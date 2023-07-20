package Ejercicio_2;

import javax.swing.*;

public class WelcomeForm extends JFrame{
    private JLabel welcomeLabel;

    public WelcomeForm(String username) {
        initComponents();
        welcomeLabel.setText("¡Bienvenido, " + username + "!");
    }

    private void initComponents() {
        welcomeLabel = new JLabel();
        add(welcomeLabel);
        setTitle("Bienvenida");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        pack();
        setLocationRelativeTo(null);
    }


}
