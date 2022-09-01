package com.ssafy.ws.controller;

import java.util.ArrayList;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DuplicateKeyException;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.ssafy.ws.dto.User;
import com.ssafy.ws.dto.service.UserService;
import com.ssafy.ws.util.DuplicateIDException;

@RequestMapping("/api")
@RestController
public class UserRestController {

    private static final Logger log = LoggerFactory.getLogger(UserRestController.class);

    @Autowired
    private UserService userService;

    @PostMapping("/user")
    public String insertUser(@RequestBody User user) throws DuplicateIDException {
        log.info("insertUser: {}", user);
        int result = 0;
        try {
            result = userService.insertUser(user);
        } catch (DuplicateKeyException e) {
            throw new DuplicateIDException("A100", "이미 등록된 사용자가 있습니다.");
        } catch (Exception e) {
            e.printStackTrace();
        }
        return (result == 1) ? "success" : "failed";
    }

    @PutMapping("/user")
    public String modifyUser(@RequestBody User user) throws Exception {
        log.info("user: {}", user);
        int result = userService.modifyUser(user);
        String resultString = "failed";
        if (result == 1) {
            resultString = "success";
        } else {
            throw new Exception("500");
        }
        return resultString;
    }

    @DeleteMapping("/user/{id}")
    public String deleteUser(@PathVariable String id) {
        int result = userService.deleteUser(id);
        return (result == 1) ? "success" : "failed";
    }

    @GetMapping("/user/{id}")
    public User selectUser(@PathVariable String id) throws Exception {
        log.info(id);
        User result = null;
        result = userService.selectUser(id);
        if (result == null) {
            throw new Exception("500");
        }
        return result;
    }

    @GetMapping("/user")
    public List<User> selectAll() {
        return userService.selectAll();
    }

}
