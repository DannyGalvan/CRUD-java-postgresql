package com.db.hibernateConnection.Data;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;

import com.db.hibernateConnection.Context.PersistenceManager;
import com.db.hibernateConnection.Entities.Student;
import com.db.hibernateConnection.Interfaces.StudentRepository;

public class StudentData implements StudentRepository {
  EntityManager em = PersistenceManager.getEntityManager();

  public Student getStudent(String carne) {
    try {
      Student student = em.find(Student.class, carne);
      return student;
    } catch (Exception e) {
      System.out.println("Error al obtener el estudiante: " + e.getMessage());
      return null;
    }
  }

  public List<Student> getAllStudents() {
    try {
      CriteriaBuilder cb = em.getCriteriaBuilder();
      CriteriaQuery<Student> cq = cb.createQuery(Student.class);
      Root<Student> rootEntry = cq.from(Student.class);
      CriteriaQuery<Student> all = cq.select(rootEntry).where(cb.like(rootEntry.get("Nombre").as(String.class), "%a%"));

      List<Student> students = em.createQuery(all).getResultList();

      return students;
    } catch (Exception e) {
      System.out.println("Error al obtener los estudiantes: " + e.getMessage());
      return null;
    }
  }

  public void addStudent(Student student) {
    try {
      em.getTransaction().begin();
      em.persist(student);
      em.getTransaction().commit();

    } catch (Exception e) {
      System.out.println("Error al agregar el estudiante: " + e.getMessage());
    }
  }

  public void updateStudent(Student student) {
    try {
      em.getTransaction().begin();
      em.merge(student);
      em.getTransaction().commit();

    } catch (Exception e) {
      System.out.println("Error al actualizar el estudiante: " + e.getMessage());
    }
  }

  public void deleteStudent(String carne) {
    try {
      Student student = em.find(Student.class, carne);
      em.getTransaction().begin();
      em.remove(student);
      em.getTransaction().commit();

    } catch (Exception e) {
      System.out.println("Error al eliminar el estudiante: " + e.getMessage());
    }
  }
}
