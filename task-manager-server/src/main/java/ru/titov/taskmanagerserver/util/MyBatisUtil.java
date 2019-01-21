package ru.titov.taskmanagerserver.util;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import java.io.IOException;
import java.io.InputStream;

public enum MyBatisUtil {
    ;

    private static final String RESOURCE = "mybatis-config.xml";

    private static SqlSessionFactory sqlSessionFactory;

    static {
        final InputStream inputStream;
        try {
            inputStream = Resources.getResourceAsStream(RESOURCE);
            sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static SqlSessionFactory getSqlSessionFactory() {
        return sqlSessionFactory;
    }

}
