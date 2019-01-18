package ru.titov.taskmanagerserver.config;

import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

public enum  AppConfig {
    ;

    public static final String JDBC_DRIVER;

    public static final String DB_URL;

    public static final String DB_LOGIN;

    public static final String DB_PASSWORD;

    public static final String SERVER_HOST;

    public static final String SERVER_PORT;

    static {
        final Properties properties = new Properties();
        try (final InputStream inputStream = AppConfig.class.getClassLoader().getResourceAsStream("application.properties")){
            properties.load(inputStream);
        } catch (IOException e) {
            e.printStackTrace();
        }
        JDBC_DRIVER = properties.getProperty("datasource.driverClassName");
        DB_URL = properties.getProperty("datasource.url");
        DB_LOGIN = properties.getProperty("datasource.login");
        DB_PASSWORD = properties.getProperty("datasource.password");
        SERVER_HOST = properties.getProperty("server.host");
        SERVER_PORT = properties.getProperty("server.port");
    }

}
