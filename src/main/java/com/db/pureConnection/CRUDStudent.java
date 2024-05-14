package com.db.pureConnection;

import java.util.ArrayList;

import com.db.App;

import io.github.cdimascio.dotenv.Dotenv;

public class CRUDStudent {
  private Dotenv config = Dotenv.configure().filename(App.getNameConfiguration()).load();

  public void run() {
    StudentDB StudentDB = new StudentDB();

    Student e1 = new Student(config.get("CARNE"), config.get("NOMBRE"),
        config.get("APELLIDO"), Integer.parseInt(config.get("EDAD")),
        config.get("SEXO"));
    StudentDB.agregar(e1);

    // Obtener un registro
    Student e2 = StudentDB.obtener(config.get("CARNE"));
    System.out.println(e2);

    // Actualizar registro
    e1.setNombre(config.get("SET_NOMBRE"));
    StudentDB.actualizar(e1);
    System.out.println("Se actualizó registro...");

    // Eliminar registro
    StudentDB.eliminar(config.get("CARNE"));
    System.out.println("Se eliminó registro...");

    // Listar todos los registros
    ArrayList<Student> a = StudentDB.obtenerTodos();
    for (Student student : a) {
      System.out.println(student.toString());
    }
  }
}
