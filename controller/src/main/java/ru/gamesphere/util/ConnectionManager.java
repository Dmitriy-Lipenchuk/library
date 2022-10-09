package ru.gamesphere.util;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConnectionManager {
    private static final String USERNAME = "postgres";
    private static final String PASSWORD = "123456789";
    private static final String URL = "jdbc:postgresql://localhost:5432/gradle_first_task";

    private ConnectionManager() {
    }

    public static Connection getConnection() {
        try {
            return DriverManager.getConnection(URL, USERNAME, PASSWORD);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
}
