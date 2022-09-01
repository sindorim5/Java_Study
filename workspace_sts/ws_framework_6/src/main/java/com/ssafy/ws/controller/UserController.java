package com.ssafy.ws.controller;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import com.ssafy.ws.dto.User;
import com.ssafy.ws.dto.service.UserService;

@Controller
public class UserController {
    
    private static final Logger log = LoggerFactory.getLogger(UserController.class);
    
    @Autowired
    private UserService userService;
    
    @GetMapping("/user")
    public String getUserTable(Model model) {
        List<User> userList = userService.selectAll();
        log.info("userList: {}", userList);
        model.addAttribute("userDto", userList);
        return "user";
    }

}
