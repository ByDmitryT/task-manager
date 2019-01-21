package ru.titov.taskmanagerserver.service;

import org.apache.ibatis.session.SqlSession;
import ru.titov.taskmanagerserver.api.service.TransactionService;

public class TransactionServiceImpl implements TransactionService {

    private final SqlSession sqlSession;

    public TransactionServiceImpl(SqlSession sqlSession) {
        this.sqlSession = sqlSession;
    }

    @Override
    public void commit() {
        sqlSession.commit();
    }

    @Override
    public void rollback() {
        sqlSession.rollback();
    }

}
