package com.ssafy.guestbook.model.service;

import java.util.Map;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ssafy.guestbook.model.MemberDto;
import com.ssafy.guestbook.model.mapper.UserDao;

@Service
public class UserServiceImpl implements UserService {
    
    @Autowired
    private UserDao dao;
    
//    @Autowired
//    private SqlSession sqlSession;
    
    @Override
    public MemberDto login(Map<String, String> map) throws Exception {
        if(map.get("userid") == null || map.get("userpwd") == null)
            return null;
//        UserDaoImpl의 login 메소드를 갖고 오는 것과 같다
//        return sqlSession.getMapper(UserDao.class).login(map);
        return dao.login(map);
    }

}
