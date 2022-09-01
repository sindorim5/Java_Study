package com.ssafy.ws.dto.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ssafy.ws.dto.User;
import com.ssafy.ws.dto.mapper.UserMapper;

@Service
public class UserServiceImpl implements UserService {
    
    @Autowired
    private UserMapper mapper;

    @Override
    public int insertUser(User user) {
        return mapper.insertUser(user);
    }

    @Override
    public int modifyUser(User user) {
        return mapper.modifyUser(user);
    }

    @Override
    public int deleteUser(String id) {
        return mapper.deleteUser(id);
    }

    @Override
    public User selectUser(String id) {
        return mapper.selectUser(id);
    }

    @Override
    public List<User> selectAll() {
        return mapper.selectAll();
    }

}
