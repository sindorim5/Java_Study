package com.ssafy.ws.dto.service;

import java.util.List;

import com.ssafy.ws.dto.User;
import com.ssafy.ws.util.DuplicateIDException;

public interface UserService {
    int insertUser(User user) throws DuplicateIDException;
    int modifyUser(User user) throws Exception;
    int deleteUser(String id);
    User selectUser(String id) throws Exception;
    List<User> selectAll();
}
