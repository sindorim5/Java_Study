package com.ssafy.guestbook.controller;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.ssafy.guestbook.model.MemberDto;
import com.ssafy.guestbook.model.service.UserService;

@RequestMapping("/admin")
@RestController
@CrossOrigin("*")
public class AdminController {

    private static final Logger logger = LoggerFactory.getLogger(AdminController.class);

    @Autowired
    private UserService userService;

    @GetMapping("/user")
    public List<MemberDto> allUser() {
        List<MemberDto> dto = userService.userList();
        return dto;
    }

    @GetMapping("/user/{userid}")
    public MemberDto userInfo(@PathVariable String userid) {
        MemberDto dto = userService.userInfo(userid);
        return dto;
    }

    @PostMapping("/user")
    public void registerUser(@RequestBody MemberDto dto) {
        logger.info("dto: {}", dto);
        userService.userRegister(dto);
    }

    @PutMapping("/user/{userid}")
    public void modifyUser(@PathVariable String userid, @RequestBody MemberDto dto) {
        logger.info("userid: {}, dto: {}", userid, dto);
        userService.userModify(dto);
    }
    
    @DeleteMapping("/user/{userid}")
    public void deleteUser(@PathVariable String userid) {
        userService.userDelete(userid);
    }

}
