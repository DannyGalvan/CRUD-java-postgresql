package com.db.pureConnection;

public class Student {

  private String Carne;
  private String Nombre;
  private String Apellido;
  private int Edad;
  private String Sexo;

  public Student() {
  }

  public Student(String carne, String nombre, String apellido, int edad, String sexo) {
    this.Carne = carne;
    this.Nombre = nombre;
    this.Apellido = apellido;
    this.Edad = edad;
    this.Sexo = sexo;
  }

  public String getCarne() {
    return Carne;
  }

  public void setCarne(String carne) {
    Carne = carne;
  }

  public String getNombre() {
    return Nombre;
  }

  public void setNombre(String nombre) {
    Nombre = nombre;
  }

  public String getApellido() {
    return Apellido;
  }

  public void setApellido(String apellido) {
    Apellido = apellido;
  }

  public int getEdad() {
    return Edad;
  }

  public void setEdad(int edad) {
    Edad = edad;
  }

  public String getSexo() {
    return Sexo;
  }

  public void setSexo(String sexo) {
    Sexo = sexo;
  }

  @Override
  public String toString() {
    return "Datos de estudiante: Carne: " + getCarne() + " Nombre: " + getNombre() + " Apellido: " + getApellido()
        + " Edad: " + getEdad() + " Sexo: " + getSexo();
  }

}
