package ru.titov.taskmanagerserver.database;

import ru.titov.taskmanagerserver.App;

import java.io.IOException;
import java.io.InputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Properties;

public enum DatabaseConnection {
    ;

    private static Connection connection;

    static {
        final Properties properties = new Properties();
        final InputStream inputStream = DatabaseConnection.class.getClassLoader().getResourceAsStream("application.properties");
        try {
            properties.load(inputStream);
            final String jdbcDriver = properties.getProperty("datasource.driverClassName");
            final String dbUrl = properties.getProperty("datasource.url");
            final String login = properties.getProperty("datasource.login");
            final String password = properties.getProperty("datasource.password");
            Class.forName(jdbcDriver);
            connection = DriverManager.getConnection(dbUrl, login, password);
        } catch (SQLException | ClassNotFoundException | IOException e) {
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
