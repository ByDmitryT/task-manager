package ru.titov.taskmanagerserver.api.service;

import org.hibernate.SessionFactory;
import org.jetbrains.annotations.NotNull;

public interface HibernateService {

    @NotNull
    SessionFactory getSessionFactory();

}
