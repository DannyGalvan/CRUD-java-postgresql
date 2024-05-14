package com.db.hibernateConnection.Interfaces;

import java.util.List;

import com.db.hibernateConnection.Entities.Student;

public interface StudentRepository {
  Student getStudent(String carne);
  List<Student> getAllStudents();
  void addStudent(Student student);
  void updateStudent(Student student);
  void deleteStudent(String carne);
}
