package com.ssafy.util;

import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;

public class SqlMapConfig {

    private static SqlSessionFactory factory;
    

    public static SqlSession getSqlSession() {
        return factory.openSession();
    }
    
}
