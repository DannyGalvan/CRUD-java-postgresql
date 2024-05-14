package com.db;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import org.junit.Before;
import org.junit.Test;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import com.db.pureConnection.Student;
import com.db.pureConnection.StudentDB;

public class StudentDBTest {
  @Mock
  private Connection conn;

  @Mock
  private PreparedStatement st;

  private StudentDB studentDB;

  @Before
  public void setUp() throws Exception {
    MockitoAnnotations.openMocks(this);
    studentDB = new StudentDB(conn);
  }

  @Test
  public void testAgregar() throws SQLException {
    Student student = new Student();
    student.setCarne("123");
    student.setNombre("John");
    student.setApellido("Doe");
    student.setEdad(20);
    student.setSexo("M");

    when(conn.prepareStatement(any(String.class))).thenReturn(st);

    studentDB.agregar(student);

    verify(st, times(1)).setString(1, student.getCarne());
    verify(st, times(1)).setString(2, student.getNombre());
    verify(st, times(1)).setString(3, student.getApellido());
    verify(st, times(1)).setInt(4, student.getEdad());
    verify(st, times(1)).setString(5, String.valueOf(student.getSexo()));
    verify(st, times(1)).executeUpdate();
  }

  @Test
  public void testActualizar() throws SQLException {
    Student student = new Student();
    student.setCarne("123");
    student.setNombre("John");
    student.setApellido("Doe");
    student.setEdad(20);
    student.setSexo("M");

    when(conn.prepareStatement(any(String.class))).thenReturn(st);

    studentDB.actualizar(student);

    verify(st, times(1)).setString(1, student.getNombre());
    verify(st, times(1)).setString(2, student.getApellido());
    verify(st, times(1)).setInt(3, student.getEdad());
    verify(st, times(1)).setString(4, String.valueOf(student.getSexo()));
    verify(st, times(1)).setString(5, student.getCarne());
    verify(st, times(1)).executeUpdate();
  }

  @Test
  public void testEliminar() throws SQLException {
    when(conn.prepareStatement(any(String.class))).thenReturn(st);

    studentDB.eliminar("123");

    verify(st, times(1)).setString(1, "123");
    verify(st, times(1)).executeUpdate();
  }

  @Test
  public void testObtener() throws SQLException {
    // Configuración de la simulación del PreparedStatement
    when(conn.prepareStatement(any(String.class))).thenReturn(st);

    // Crear un ResultSet simulado
    ResultSet rs = mock(ResultSet.class);
    when(st.executeQuery()).thenReturn(rs);

    // Configurar el comportamiento del ResultSet simulado
    when(rs.next()).thenReturn(true); // Simular que hay al menos una fila
    when(rs.getString(1)).thenReturn("7590-20-14568");
    when(rs.getString(2)).thenReturn("Juan");
    when(rs.getString(3)).thenReturn("Pérez");
    when(rs.getInt(4)).thenReturn(20);
    when(rs.getString(5)).thenReturn("M");

    // Ejecutar el método que se está probando
    studentDB.obtener("7590-20-14568");

    // Verificar que se configuraron correctamente los parámetros del
    // PreparedStatement
    verify(st, times(1)).setString(1, "7590-20-14568");

    // Verificar que se ejecutó la consulta
    verify(st, times(1)).executeQuery();

    // Verificar que se accedió al ResultSet
    verify(rs, times(1)).next();
    verify(rs, times(1)).getString(1);
    verify(rs, times(1)).getString(2);
    verify(rs, times(1)).getString(3);
    verify(rs, times(1)).getInt(4);
    verify(rs, times(1)).getString(5);
  }

  @Test
  public void testObtenerTodos() throws SQLException {
    // Crear un PreparedStatement simulado
    Statement st = mock(Statement.class);
    when(conn.createStatement()).thenReturn(st);

    // Crear un ResultSet simulado
    ResultSet rs = mock(ResultSet.class);
    when(st.executeQuery(any(String.class))).thenReturn(rs);

    studentDB.obtenerTodos();

    verify(st, times(1)).executeQuery(any(String.class));
  }
}
