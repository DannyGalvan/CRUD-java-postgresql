package com.db.hibernateConnection.Context;

import java.util.Properties;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import com.db.App;

import io.github.cdimascio.dotenv.Dotenv;

public class PersistenceManager {
    private static final String PERSISTENCE_UNIT_NAME = "unidad-de-persistencia";
    private static EntityManagerFactory emf;

    private PersistenceManager() {
    }

  public static EntityManager getEntityManager() {
     Dotenv dotenv = Dotenv.configure().filename(App.getNameConfiguration()).load();
      if (emf == null) {
        Properties properties = new Properties();
        properties.setProperty("javax.persistence.jdbc.driver", dotenv.get("JDBC_DRIVER"));
        properties.setProperty("javax.persistence.jdbc.url", dotenv.get("DB_URL"));
        properties.setProperty("javax.persistence.jdbc.user", dotenv.get("DB_USER"));
        properties.setProperty("javax.persistence.jdbc.password", dotenv.get("BD_PASSWORD"));
        emf = Persistence.createEntityManagerFactory(PERSISTENCE_UNIT_NAME, properties);
      }
      return emf.createEntityManager();
  }

    public static void close() {
        if (emf != null && emf.isOpen()) {
            emf.close();
        }
    }
}