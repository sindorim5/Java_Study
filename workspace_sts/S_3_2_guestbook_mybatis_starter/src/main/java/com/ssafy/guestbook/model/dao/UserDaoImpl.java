package com.ssafy.guestbook.model.dao;

import java.sql.SQLException;
import java.util.Map;

import org.apache.ibatis.session.SqlSession;
import org.springframework.stereotype.Repository;

import com.ssafy.guestbook.model.MemberDto;
import com.ssafy.util.SqlMapConfig;

@Repository
public class UserDaoImpl implements UserDao {

    @Override
    public MemberDto login(Map<String, String> map) throws SQLException {
        try (SqlSession session = SqlMapConfig.getSqlSession();) {
            return session.selectOne("com.ssafy.guestbook.model.dao.UserDao.login", map);
        }
    }

}
