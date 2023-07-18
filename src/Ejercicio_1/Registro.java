package Ejercicio_1;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.io.IOException;
import java.io.ObjectOutputStream;
import java.io.FileOutputStream;

public class Registro {
    private JTextField Nombre;
    private JTextField Apellido;
    private JTextField Codigo;
    private JButton guardarButton;
    private JPanel Formulario;
    private ArrayList<Datos> listaDatos;
    private int ind;

    public Registro() {
        listaDatos = new ArrayList<>();

        guardarButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                JOptionPane.showMessageDialog(guardarButton, "Usuario guardado");
                String nombre = Nombre.getText();
                String apellido = Apellido.getText();
                String codigo = Codigo.getText();

                Datos ingreso = new Datos(nombre, apellido, codigo);
                listaDatos.add(ingreso);

                int lastIndex = listaDatos.size() - 1;
                String filePath = listaDatos.get(lastIndex).getCodigo() + ".dat";
                try (FileOutputStream fileOut = new FileOutputStream(filePath);
                     ObjectOutputStream objOut = new ObjectOutputStream(fileOut)) {
                    objOut.writeObject(listaDatos.get(lastIndex));
                    System.out.println("Archivo " + filePath + " guardado correctamente");
                } catch (IOException ex) {
                    throw new RuntimeException(ex);
                }

                Nombre.setText("");
                Apellido.setText("");
                Codigo.setText("");
            }
        });
    }

    public static void main(String[] args) {
        JFrame frame = new JFrame("Registro");
        frame.setContentPane(new Registro().Formulario);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.pack();
        frame.setVisible(true);
    }
}