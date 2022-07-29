package com.ssafy.cafe.model.service;

import java.awt.List;
import java.util.ArrayList;

import com.ssafy.cafe.model.dao.UserDao;
import com.ssafy.cafe.model.dao.UserDaoImpl;
import com.ssafy.cafe.model.dto.User;
import com.ssafy.cafe.util.DuplicateUserException;

public class UserServiceImpl implements UserService{
    
    UserDao mgr = new UserDaoImpl().getInstance();
    private static UserServiceImpl userServiceInstance;
    public static UserService getInstance() {
        if(userServiceInstance == null) {
            userServiceInstance = new UserServiceImpl();
        }
        return userServiceInstance;
    }
    
    /**
     * 사용자 정보를 DB에 저장한다.
     * 
     * @param user
     */
    public void join(User user) {
        try {
            mgr.insert(user);
        } catch (DuplicateUserException e) {
            throw e;
            // TODO: handle exception
        }

    }

    /**
     * id, pass에 해당하는 User 정보를 반환한다.
     * 
     * @param id
     * @param pass
     * @return
     * 조회된 User 정보를 반환한다.
     */
    public User login(String id, String pass) {
        try {
            User user = new User();
            if(((mgr.select(id)).getPass()).equals(pass)) {
                System.out.println(mgr.select(id));
                user = mgr.select(id);
            }
           return user;
            
        } catch (Exception e) {
            // TODO: handle exception
            System.out.println(e);
        }
        return null;
        
    }
    
    /**
     * id에 해당하는 사용자 정보를 삭제한다.
     * @param id
     */
    public void leave(String id) {
        mgr.delete(id);
    }
    
    /**
     * 해당 아이디가 이미 사용 중인지를 반환한다.
     * @param id
     * @return
     */
    public boolean isUsedId(String id) {
        if((mgr.select(id)).getId() != null) return true;
        else return false;
    }
}
