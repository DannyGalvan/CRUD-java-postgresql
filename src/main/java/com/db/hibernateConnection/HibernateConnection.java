package com.db.hibernateConnection;

import java.time.LocalDate;

import com.db.hibernateConnection.Context.PersistenceManager;
import com.db.hibernateConnection.Data.StudentData;
import com.db.hibernateConnection.Entities.Student;
import com.db.hibernateConnection.Services.StudentService;

public class HibernateConnection {
  StudentData studentRepository = new StudentData();
  StudentService studentService = new StudentService(studentRepository);

  public void run() {

    Student student = new Student("7590-20-121132", "Juan", "Martinez", 26, "M", "Ingenieria en Sistemas", LocalDate.now());

    studentService.addStudent(student);

    student.setNombre("Filemon");

    studentService.updateStudent(student);

    System.out.println(studentService.getStudent("7590-20-121132"));

    studentService.deleteStudent("7590-20-1215444");

    studentService.getAllStudents().stream().forEach(s -> System.out.println(s));

    PersistenceManager.close();
  }
}
