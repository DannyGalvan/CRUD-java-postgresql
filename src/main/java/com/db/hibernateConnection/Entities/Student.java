package com.db.hibernateConnection.Entities;

import java.time.LocalDate;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

import org.hibernate.annotations.ColumnDefault;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;


@Getter 
@Setter
@ToString
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "students")
public class Student {
  @Id
  private String Carne;
  private String Nombre;
  private String Apellido;
  private int Edad;

  @ColumnDefault("'M'")
  private String Sexo;
  
  @ColumnDefault("'Ingenieria en Sistemas'")
  private String Carrera;

  @ColumnDefault("CURRENT_TIMESTAMP")
  private LocalDate CreatedAt;
}
