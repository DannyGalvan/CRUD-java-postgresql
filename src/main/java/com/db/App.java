package com.db;

import java.util.ArrayList;

import io.github.cdimascio.dotenv.Dotenv;

/**
 * Crud operations
 *
 */
public class App {

    private static String nameConfiguration = ".env.development";
    private static Dotenv config = Dotenv.configure().filename(nameConfiguration).load();

    public static String getNameConfiguration() {
        return nameConfiguration;
    }
    public static void main(String[] args) {
        StudentDB StudentDB = new StudentDB();

        Student e1 = new Student(config.get("CARNE"), config.get("NOMBRE"), config.get("APELLIDO"), Integer.parseInt(config.get("EDAD")), config.get("SEXO"));
        StudentDB.agregar(e1);

        // Obtener un registro
        Student e2 = StudentDB.obtener(config.get("CARNE"));
        System.out.println(e2);

        // Actualizar registro
        e1.setNombre(config.get("SET_NOMBRE"));
        StudentDB.actualizar(e1);
        System.out.println("Se actualizó registro...");

        StudentDB.eliminar(config.get("CARNE"));
        System.out.println("Se eliminó registro...");

        // Listar todos los registros
        ArrayList<Student> a = StudentDB.obtenerTodos();
        for (Student student : a) {
            System.out.println(student.toString());
        }
    }
}
