package ru.titov.taskmanagerserver.factory;

import org.hibernate.SessionFactory;

import javax.enterprise.inject.Produces;
import javax.inject.Inject;
import javax.persistence.EntityManager;

public class EntityManagerFactory {

    @Inject
    private SessionFactory sessionFactory;

    @Produces
    public EntityManager getEntityManager() {
        return sessionFactory.createEntityManager();
    }

}
