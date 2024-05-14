package com.db.pureConnection;

import java.sql.Connection;
import java.sql.DriverManager;

import com.db.App;

import io.github.cdimascio.dotenv.Dotenv;

public class Conection {
  private String url;
  private String user;
  private String password;  

  private final Dotenv dotenv = Dotenv.configure().filename(App.getNameConfiguration()).load();

  public Conection() {
    this.url = dotenv.get("DB_URL");
    this.user = dotenv.get("DB_USER");
    this.password = dotenv.get("BD_PASSWORD");
    System.out.println("Conectando a la base de datos...");
  }

  public Connection GetConnection() {
    try {
      Connection connection = DriverManager.getConnection(url, user, password);
      System.out.println("Conexión exitosa");
      return connection;
    } catch (Exception e) {
      System.out.println("Error al conectar a la base de datos:" + e.getMessage());
      return null;
    }
  }
}
