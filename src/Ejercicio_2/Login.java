package Ejercicio_2;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.*;

public class Login extends JFrame{
    private JTextField usuarioField;
    private JButton iniciarButton;
    private JPasswordField contraseñaField;
    private JPanel inicioSesionPanel;

    public Login() {
        initComponents();
        iniciarButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String username = usuarioField.getText();
                char[] passwordChars = contraseñaField.getPassword();
                String password = new String(passwordChars);

                if (validateLogin(username, password)) {
                    showWelcomeForm(username);
                } else {
                    JOptionPane.showMessageDialog(Login.this,
                            "Usuario o contraseña incorrectos",
                            "Error de inicio de sesión",
                            JOptionPane.ERROR_MESSAGE);
                }
            }
        });
    }

    private boolean validateLogin(String username, String password) {
        try (ObjectInputStream ois = new ObjectInputStream(new FileInputStream("usuarios.dat"))) {
            for (int i = 0; i < 5; i++) {
                Usuario usuario = (Usuario) ois.readObject();
                if (usuario.getNombre().equals(username) && usuario.getClave().equals(password)) {
                    return true;
                }
            }
        } catch (IOException | ClassNotFoundException e) {
            e.printStackTrace();
        }
        return false;
    }

    private void showWelcomeForm(String username) {
        WelcomeForm welcomeForm = new WelcomeForm(username);
        welcomeForm.setVisible(true);
        dispose();
    }

    private void initComponents() {
        add(inicioSesionPanel);
        setTitle("Inicio_Sesión");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        pack();
        setLocationRelativeTo(null);
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
                Login loginForm = new Login();
                loginForm.setVisible(true);
            }
        });
    }
}

