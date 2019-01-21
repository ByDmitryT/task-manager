package ru.titov.taskmanagerserver.api.service;

public interface TransactionService {

    void commit();

    void rollback();

}
