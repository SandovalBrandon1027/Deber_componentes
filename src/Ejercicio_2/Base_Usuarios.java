package Ejercicio_2;

import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;


public class Base_Usuarios {
    public static void main(String[] args) {
        Usuario[] usuarios = {
                new Usuario("usuario1", "clave1"),
                new Usuario("usuario2", "clave2"),
                new Usuario("usuario3", "clave3"),
                new Usuario("usuario4", "clave4"),
                new Usuario("usuario5", "clave5")
        };

        try (ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream("usuarios.dat"))) {
            for (Usuario usuario : usuarios) {
                oos.writeObject(usuario);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
