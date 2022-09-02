package com.ssafy.ws.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.ssafy.ws.dto.User;
import com.ssafy.ws.model.service.UserService;

@RequestMapping("/userapi")
@RestController
@CrossOrigin("*")
public class UserRestController {
    
    private static final Logger logger = LoggerFactory.getLogger(UserRestController.class);

    @Autowired
    private UserService userService;
    
    @GetMapping("/user/{id}")
    public ResponseEntity<User> selectUser(@PathVariable String id) {
        logger.info(id);
        User userDto = userService.select(id);
        if (userDto != null) {
            return new ResponseEntity<User>(userDto, HttpStatus.OK);
        } else {
            return new ResponseEntity<User>(userDto, HttpStatus.NO_CONTENT);
        }
    }
    
}
