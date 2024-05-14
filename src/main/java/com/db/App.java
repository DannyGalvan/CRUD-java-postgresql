package com.db;

import com.db.hibernateConnection.HibernateConnection;
import com.db.pureConnection.CRUDStudent;

/**
 * Crud operations
 *
 */
public class App {
    private static String nameConfiguration = ".env.development";
    private static CRUDStudent crudStudent = new CRUDStudent();
    private static HibernateConnection hibernateConnection = new HibernateConnection();

    public static void main(String[] args) {

        // ejecucion de las operaciones crud con hibernate
        hibernateConnection.run();

        // ejecucion de las operaciones crud con jdbc
        crudStudent.run();
    }

    public static String getNameConfiguration() {
        return nameConfiguration;
    }
}
