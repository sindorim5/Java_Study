package com.ssafy.ws.controller;

import java.util.ArrayList;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.ssafy.ws.dto.User;
import com.ssafy.ws.util.DuplicateIDException;

@RequestMapping("/api")
@RestController
public class UserRestController {

    private static final Logger log = LoggerFactory.getLogger(UserRestController.class);
    List<User> userList = new ArrayList<User>();

    @PostMapping("/user")
    public String insertUser(@RequestBody User user) {
        for (User element : userList) {
            if (element.getId().equals(user.getId())) {
                throw new DuplicateIDException("A100", "이미 등록된 사용자가 있습니다.");
            }
        }
        boolean result = userList.add(user);
        String resultString = "failed";
        if (result == true) {
            resultString = "success";
        }
        return resultString;
    }

    @PutMapping("/user")
    public String modifyUser(@RequestBody User user) throws Exception {
        log.info("user: {}", user);
        int index = -1;
        for (User element : userList) {
            if (element.getId().equals(user.getId())) {
                index = userList.indexOf(element);
                userList.set(index, user);
                break;
            }
        }
        if (index == -1) {
            throw new Exception("500");
        }
        return "User not Found";
    }

    @DeleteMapping("/user/{id}")
    public String deleteUser(@PathVariable String id) {
        String result = "Failed";
        for (User element : userList) {
            if (element.getId().equals(id)) {
                userList.remove(element);
                result = "success";
                break;
            }
        }
        return result;
    }

    @GetMapping("/user/{id}")
    public User selectUser(@PathVariable String id) throws Exception {
        log.info(id);
        User result = null;
        for (User element : userList) {
            if (element.getId().equals(id)) {
                result = element;
                break;
            }
        }
        if (result == null) {
            throw new Exception("500");
        }
        return result;
    }

    @GetMapping("/user")
    public List<User> selectAll() {
        log.info("Get userList: {}", userList);
        return userList;
    }

}
