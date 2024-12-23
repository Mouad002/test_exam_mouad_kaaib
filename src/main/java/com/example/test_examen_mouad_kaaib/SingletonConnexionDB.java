package com.example.test_examen_mouad_kaaib;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class SingletonConnexionDB {
    private static final String URL = "jdbc:mysql://localhost:3306/test_examen";
    private static final String USER = "root";
    private static final String PASSWORD = "root";
    private static final Connection connection;

    static {
        try {
            connection = DriverManager.getConnection(URL, USER, PASSWORD);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public static Connection getConnection() {
        return connection;
    }

    public static void destroyConnection() throws SQLException{
        connection.close();
    }
}
