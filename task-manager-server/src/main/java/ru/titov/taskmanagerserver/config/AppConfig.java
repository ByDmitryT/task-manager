package ru.titov.taskmanagerserver.config;

import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

public enum  AppConfig {
    ;

    public static final String RESOURCE = "application.properties";

    public static final String DB_DRIVER;

    public static final String DB_URL;

    public static final String DB_LOGIN;

    public static final String DB_PASSWORD;

    public static final String DB_DIALECT;

    public static final String DB_HBM2DDL_AUTO;

    public static final String DB_SHOW_SQL;

    public static final String SERVER_HOST;

    public static final String SERVER_PORT;

    public static final String TOKEN_SECRET;

    public static final long TOKEN_TIMEOUT;

    static {
        final Properties properties = new Properties();
        try (final InputStream inputStream = AppConfig.class.getClassLoader().getResourceAsStream(RESOURCE)){
            properties.load(inputStream);
        } catch (IOException e) {
            e.printStackTrace();
        }
        DB_DRIVER = properties.getProperty("datasource.driverClassName");
        DB_URL = properties.getProperty("datasource.url");
        DB_LOGIN = properties.getProperty("datasource.login");
        DB_PASSWORD = properties.getProperty("datasource.password");
        DB_DIALECT = properties.getProperty("datasource.dialect");
        DB_HBM2DDL_AUTO = properties.getProperty("datasource.hbm2ddlauto");
        DB_SHOW_SQL = properties.getProperty("datasource.showSql");
        SERVER_HOST = properties.getProperty("server.host");
        SERVER_PORT = properties.getProperty("server.port");
        TOKEN_SECRET = properties.getProperty("token.secret");
        TOKEN_TIMEOUT = Long.parseLong(properties.getProperty("token.timeout"));
    }

}
