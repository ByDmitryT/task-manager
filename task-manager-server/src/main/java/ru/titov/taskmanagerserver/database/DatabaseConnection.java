package ru.titov.taskmanagerserver.database;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public enum DatabaseConnection {
    ;

    private static final String JDBC_DRIVER = "org.h2.Driver";

    private static final String DB_URL = "jdbc:h2:~/test";

    private static final String USER = "sa";

    private static final String PASSWORD = "";

    private static Connection connection;

    static {
        try {
            Class.forName(JDBC_DRIVER);
            connection = DriverManager.getConnection(DB_URL, USER, PASSWORD);
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
