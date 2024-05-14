package com.db;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;

public class StudentDB {
    Connection conn;
    
    public StudentDB() {
        conn = new Conection().GetConnection();
    }

    public StudentDB(Connection conn) {
        this.conn = conn;
    }

    public void agregar(Student e) {
        
    PreparedStatement st = null;
    
        try {
          String sql = "INSERT INTO students (carne, nombre, apellido, edad, sexo) " +
                 "VALUES (?, ?, ?, ?, ?)";

          st = conn.prepareStatement(sql);
          st.setString(1, e.getCarne());
          st.setString(2, e.getNombre());
          st.setString(3, e.getApellido());
          st.setInt(4, e.getEdad());
          st.setString(5, String.valueOf(e.getSexo()));
          
          st.executeUpdate();
          
        } catch (SQLException ex) {
            Logger.getLogger(StudentDB.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            if (st != null) {
                try {
                    st.close();
                } catch (SQLException ex) {
                    Logger.getLogger(StudentDB.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        }
    }
    
    public void actualizar(Student e) {
            PreparedStatement st = null;
    
        try {
          String sql = "UPDATE students SET nombre = ?, apellido = ?, edad = ?, sexo = ? " +
                 "WHERE carne = ?";

          st = conn.prepareStatement(sql);
          st.setString(1, e.getNombre());
          st.setString(2, e.getApellido());
          st.setInt(3, e.getEdad());
          st.setString(4, String.valueOf(e.getSexo()));
          st.setString(5, e.getCarne());
          
          st.executeUpdate();
          
        } catch (SQLException ex) {
            Logger.getLogger(StudentDB.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            if (st != null) {
                try {
                    st.close();
                } catch (SQLException ex) {
                    Logger.getLogger(StudentDB.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        }
    }
    
    public void eliminar(String numeroCarne) {
            PreparedStatement st = null;
    
        try {
          String sql = "DELETE FROM students " +
                 "WHERE carne = ?";

          st = conn.prepareStatement(sql);
          st.setString(1, numeroCarne);
          
          st.executeUpdate();
          
        } catch (SQLException ex) {
            Logger.getLogger(StudentDB.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            if (st != null) {
                try {
                    st.close();
                } catch (SQLException ex) {
                    Logger.getLogger(StudentDB.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        }
    }
    
    public Student obtener(String numeroCarne) {
        
        PreparedStatement st = null;
        ResultSet rs = null;
        Student e = new Student();
        
        try {
            String sql = "SELECT * " +
                   "FROM students " +
                   "WHERE carne = ?";

            st = conn.prepareStatement(sql);
            st.setString(1, numeroCarne);
            rs = st.executeQuery();

            while (rs.next()) {
              e.setCarne(rs.getString(1));
              e.setNombre(rs.getString(2));
              e.setApellido(rs.getString(3));
              e.setEdad(rs.getInt(4));
              e.setSexo(rs.getString(5));

              return e;
            }
        } catch (SQLException ex) {
            Logger.getLogger(StudentDB.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            try {
                if (rs != null) {
                    rs.close();
                }
                
                if (st != null) {
                    st.close();
                }
            } catch (SQLException ex) {
                Logger.getLogger(StudentDB.class.getName()).log(Level.SEVERE, null, ex);
            }
        }

        return null;
    }
    
    public ArrayList<Student> obtenerTodos() {
        
        Statement st = null;
        ResultSet rs = null;
        ArrayList<Student> a = new ArrayList<Student>();
        
        try {
            String sql = "SELECT * " +
                   "FROM students ";
            st = conn.createStatement();
            rs = st.executeQuery(sql);
            while (rs.next()) {
                
                Student e = new Student();
                
                e.setCarne(rs.getString(1));
                e.setNombre(rs.getString(2));
                e.setApellido(rs.getString(3));
                e.setEdad(rs.getInt(4));
                String sexo = rs.getString(5);
                if (sexo != null) {
                    e.setSexo(rs.getString(5));
                }
                
                a.add(e);
            }
            
            return a;
        } catch (SQLException ex) {
            Logger.getLogger(StudentDB.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            try {
                if (rs != null) {
                    rs.close();
                }
                
                if (st != null) {
                    st.close();
                }
            } catch (SQLException ex) {
                Logger.getLogger(StudentDB.class.getName()).log(Level.SEVERE, null, ex);
            }
        }

        return null;
    }
}
