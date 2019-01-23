package ru.titov.taskmanagerserver.util;

import lombok.Getter;
import org.hibernate.SessionFactory;
import org.hibernate.boot.Metadata;
import org.hibernate.boot.MetadataSources;
import org.hibernate.boot.registry.StandardServiceRegistry;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Environment;
import ru.titov.taskmanagerserver.config.AppConfig;
import ru.titov.taskmanagerserver.entity.Project;
import ru.titov.taskmanagerserver.entity.Task;
import ru.titov.taskmanagerserver.entity.User;

import java.util.HashMap;
import java.util.Map;

public enum HibernateUtil {
    ;

    @Getter
    private static SessionFactory sessionFactory;

    static {
        final Map<String, String> settings = new HashMap<>();
        settings.put(Environment.DRIVER, AppConfig.DB_DRIVER);
        settings.put(Environment.URL, AppConfig.DB_URL);
        settings.put(Environment.USER, AppConfig.DB_LOGIN);
        settings.put(Environment.PASS, AppConfig.DB_PASSWORD);
        settings.put(Environment.DIALECT, AppConfig.DB_DIALECT);
        settings.put(Environment.HBM2DDL_AUTO, AppConfig.DB_HBM2DDL_AUTO);
        settings.put(Environment.SHOW_SQL, AppConfig.DB_SHOW_SQL);

        final StandardServiceRegistryBuilder registryBuilder = new StandardServiceRegistryBuilder();
        registryBuilder.applySettings(settings);
        final StandardServiceRegistry registry = registryBuilder.build();
        final MetadataSources sources = new MetadataSources(registry);
        sources.addAnnotatedClass(Project.class);
        sources.addAnnotatedClass(Task.class);
        sources.addAnnotatedClass(User.class);
        final Metadata metadata = sources.getMetadataBuilder().build();
        sessionFactory = metadata.getSessionFactoryBuilder().build();
    }

}
