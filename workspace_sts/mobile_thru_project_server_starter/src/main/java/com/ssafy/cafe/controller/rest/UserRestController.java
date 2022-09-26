package com.ssafy.cafe.controller.rest;

import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;
import java.util.*;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletResponse;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.ssafy.cafe.model.dto.Grade;
import com.ssafy.cafe.model.dto.Order;
import com.ssafy.cafe.model.dto.User;
import com.ssafy.cafe.model.service.OrderService;
import com.ssafy.cafe.model.service.UserService;

import io.swagger.annotations.ApiOperation;

@RestController
@RequestMapping("/rest/user")
@CrossOrigin("*")
public class UserRestController {

    private static final Logger logger = LoggerFactory.getLogger(UserRestController.class);

    @Autowired
    UserService uService;
    
    @Autowired
    OrderService oService;
    
    @ApiOperation(value = "사용자추가", notes = "사용자 정보를 추가한다. 성공하면 true를 리턴한다.")
    @PostMapping("")
    public ResponseEntity<Integer> userRegister(@RequestBody User user) {
        boolean isUsedCheck = uService.isUsedId(user.getId());
        if (isUsedCheck) {
            return new ResponseEntity<Integer>(HttpStatus.NO_CONTENT);
        } else {
            uService.join(user);
            return new ResponseEntity<Integer>(HttpStatus.CREATED);
        }
    }
    
    @ApiOperation(value = "사용자정보", notes = "사용자의 정보와 함께 사용자의 주문 내역, 사용자 등급 정보를 반환한다.")
    @PostMapping("/info")
    public Map<String, Object> getUserData(@RequestBody User user) {
        User loginUser = uService.login(user.getId(), user.getPass());

        String userName = loginUser.getName();
        user.setName(userName);
        
        Map<String, Object> result = new HashMap<String, Object>();
        List<Order> orderList = oService.getOrdreByUser(loginUser.getId());
        
        Grade tempGrade = new Grade(loginUser.getStamps());
        result.put("grade",  tempGrade);
        result.put("user", loginUser);
        result.put("order", orderList);
        return result;
    }
    
    
    @ApiOperation(value = "사용자중복체크", notes = "request parameter로 전달된 id가 이미 사용중인지 반환한다.")
    @GetMapping("/isUsed")
    public ResponseEntity<Boolean> isUsed(String id) {
        boolean result = uService.isUsedId(id);

        return new ResponseEntity<Boolean>(result, HttpStatus.OK);
    }
    
    @PostMapping("/login")
    @ApiOperation(value = "로그인 처리 후 성공적으로 로그인 되었다면 loginId라는 쿠키를 내려보낸다.", response = User.class)
    public ResponseEntity<User> login(@RequestBody User user, HttpServletResponse response)
            throws UnsupportedEncodingException {
        User selected = uService.login(user.getId(), user.getPass());
        if (selected != null) {
            Cookie cookie = new Cookie("loginId", URLEncoder.encode(selected.getId(), "utf-8"));
            cookie.setMaxAge(1000 * 1000);
            response.addCookie(cookie);
        }
        return new ResponseEntity<User>(selected, HttpStatus.OK);
    }
}