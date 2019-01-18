package ru.titov.taskmanagerserver.database;

import ru.titov.taskmanagerserver.config.AppConfig;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public enum DatabaseConnection {
    ;

    private static Connection connection;

    static {
        try {
            Class.forName(AppConfig.JDBC_DRIVER);
            connection = DriverManager.getConnection(AppConfig.DB_URL, AppConfig.DB_LOGIN, AppConfig.DB_PASSWORD);
        } catch (SQLException | ClassNotFoundException e) {
            e.printStackTrace();
        }
    }

    public static Connection getConnection() {
        return connection;
    }

    public static void close() {
        try {
            connection.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

}
