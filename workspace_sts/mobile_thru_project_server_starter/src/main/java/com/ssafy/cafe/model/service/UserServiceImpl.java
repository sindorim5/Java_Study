package com.ssafy.cafe.model.service;

import java.util.ArrayList;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.ssafy.cafe.model.dao.UserDao;
import com.ssafy.cafe.model.dto.User;

@Service
public class UserServiceImpl implements UserService {

    private static final Logger logger = LoggerFactory.getLogger(UserServiceImpl.class);
    
    @Autowired
    private UserDao userDao;

    @Override
    public void join(User user) {
        if (user.getId() != null || user.getName() != null || user.getPass() != null) {
            if (!isUsedId(user.getId())) {
                userDao.insert(user);
            } else {
               logger.debug("중복된 ID");
            }
        } else {
            logger.debug("입력 완료 안됨");
        }
    }

    @Override
    public User login(String id, String pass) {
        User user = userDao.select(id);
        if (user != null && user.getPass().equals(pass)) {
            return user;
        } else {
            return null;
        }
    }

    @Override
    public void leave(String id) {
        
    }

    @Override
    public boolean isUsedId(String id) {
        List<User> userList = new ArrayList<User>();
        userList = userDao.selectAll();
        for (User user : userList) {
            if (user.getId().equals(id)) {
                return true;
            }
        }
        return false;
    }
}
