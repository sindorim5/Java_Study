package com.ssafy.ws.dto.mapper;

import java.util.List;

import com.ssafy.ws.dto.User;

public interface UserMapper {
    int insertUser(User user);
    int modifyUser(User user);
    int deleteUser(String id);
    User selectUser(String id);
    List<User> selectAll();
}