package com.db.hibernateConnection.Services;


import java.util.List;

import com.db.hibernateConnection.Entities.Student;
import com.db.hibernateConnection.Interfaces.StudentRepository;

public class StudentService {

  StudentRepository studentRepository;

  public StudentService(StudentRepository studentRepository) {
    this.studentRepository = studentRepository;
  }

  public Student getStudent(String carne) {
    //validar carne

    if (carne == null || carne.isEmpty()) {      
      throw new IllegalArgumentException("Carne no puede ser nulo o vacío");
    }

    return studentRepository.getStudent(carne);
  }

  public void addStudent(Student student) {

    if (student == null) {
      throw new IllegalArgumentException("Student no puede ser nulo");
    }

    if (student.getCarne() == null || student.getCarne().isEmpty()) {
      throw new IllegalArgumentException("Carne no puede ser nulo o vacío");
    }

    if (student.getNombre() == null || student.getNombre().isEmpty()) {
      throw new IllegalArgumentException("Nombre no puede ser nulo o vacío");
    }

    if (student.getApellido() == null || student.getApellido().isEmpty()) {
      throw new IllegalArgumentException("Apellido no puede ser nulo o vacío");
    }

    if (student.getEdad() <= 0) {
      throw new IllegalArgumentException("Edad no puede ser menor o igual a 0");
    }

    if (student.getSexo() == null || student.getSexo().isEmpty()) {
      throw new IllegalArgumentException("Sexo no puede ser nulo o vacío");
    }

    studentRepository.addStudent(student);
  }

  public void updateStudent(Student student) {

    if (student == null) {
      throw new IllegalArgumentException("Student no puede ser nulo");
    }

    if (student.getCarne() == null || student.getCarne().isEmpty()) {
      throw new IllegalArgumentException("Carne no puede ser nulo o vacío");
    }

    if (student.getNombre() == null || student.getNombre().isEmpty()) {
      throw new IllegalArgumentException("Nombre no puede ser nulo o vacío");
    }

    if (student.getApellido() == null || student.getApellido().isEmpty()) {
      throw new IllegalArgumentException("Apellido no puede ser nulo o vacío");
    }

    if (student.getEdad() <= 0) {
      throw new IllegalArgumentException("Edad no puede ser menor o igual a 0");
    }

    if (student.getSexo() == null || student.getSexo().isEmpty()) {
      throw new IllegalArgumentException("Sexo no puede ser nulo o vacío");
    }

    studentRepository.updateStudent(student);
  }

  public void deleteStudent(String carne) {
    //validar carne

    if (carne == null || carne.isEmpty()) {      
      throw new IllegalArgumentException("Carne no puede ser nulo o vacío");
    }
    
    studentRepository.deleteStudent(carne);
  }

  public List<Student> getAllStudents() {
    return studentRepository.getAllStudents();
  }
}
