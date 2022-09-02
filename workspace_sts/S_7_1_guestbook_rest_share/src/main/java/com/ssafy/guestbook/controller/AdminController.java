package com.ssafy.guestbook.controller;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.ssafy.guestbook.model.MemberDto;
import com.ssafy.guestbook.model.service.UserService;

@RestController
@RequestMapping("/admin")
@CrossOrigin("*")
public class AdminController {

    private static final Logger logger = LoggerFactory.getLogger(AdminController.class);
    
    @Autowired
    private UserService userService;
    
//    @RequestMapping(value = "/user", method = RequestMethod.GET)
//    public List<MemberDto> userList() {
//        List<MemberDto>  dto = userService.userList();
//        return dto;
//    }
    
//    @RequestMapping(value = "/user", method = RequestMethod.POST)
//    public void userRegister(@RequestBody MemberDto memberDto) {
//        logger.debug("userRegisger", memberDto);
//        userService.userRegister(memberDto);
//    }
    
//    @RequestMapping(value="/user/{userid}", method=RequestMethod.GET)
//    public MemberDto userInfo(@PathVariable("userid") String userid ) {
//        return userService.userInfo(userid);
//    }

//    @RequestMapping(value="/user/{userid}", method=RequestMethod.PUT)
//    public void updateUser(@RequestBody MemberDto dto) {
//        logger.debug("updateUser...", dto);
//        userService.userModify(dto);
//    }
    
    
//    @RequestMapping(value="/user/{userid}", method=RequestMethod.DELETE)
//    public void userDelete(@PathVariable("userid")String userid) {
//        userService.userDelete(userid);
//    }
    
    
    ///////////////////////////////////////////////////////////
    

    @GetMapping(value = "/user")
    public ResponseEntity<List<MemberDto>> userList() {
        List<MemberDto> list = userService.userList();
        if(list != null && !list.isEmpty()) {
            return new ResponseEntity<List<MemberDto>>(list, HttpStatus.OK);
        } else {
            return new ResponseEntity<List<MemberDto>>(list, HttpStatus.NO_CONTENT);
        }
    }
    
    @PostMapping(value = "/user")
    public ResponseEntity<Integer> userRegister(@RequestBody MemberDto memberDto) {
        int cnt = userService.userRegister(memberDto);
        if(cnt != 0) {
            return new ResponseEntity<Integer>(cnt, HttpStatus.CREATED);
        } else
            return new ResponseEntity<Integer>(HttpStatus.NO_CONTENT);
    }
    
    @GetMapping(value = "/user/{userid}")
    public ResponseEntity<MemberDto> userInfo(@PathVariable("userid") String userid) {
        logger.debug("파라미터 : {}", userid);
        MemberDto memberDto = userService.userInfo(userid);
        if(memberDto != null)
            return new ResponseEntity<MemberDto>(memberDto, HttpStatus.OK);
        else
            return new ResponseEntity<MemberDto>(memberDto, HttpStatus.NO_CONTENT);
    }
    
    @PutMapping(value = "/user/{userid}")
    public ResponseEntity<Integer> userModify(@RequestBody MemberDto memberDto) {
        int result = userService.userModify(memberDto);
        if( result == 1 ){
            logger.info("result : {}", result);
            return new ResponseEntity<Integer>(HttpStatus.OK);
        }else {
            return new ResponseEntity<Integer>(HttpStatus.NO_CONTENT);
        }
    }
    
    @DeleteMapping(value = "/user/{userid}")
    public ResponseEntity<Integer> userDelete(@PathVariable("userid") String userid) {
        int result = userService.userDelete(userid);
        
        if( result == 1 ){
            return new ResponseEntity<Integer>(HttpStatus.OK);
        }else {
            return new ResponseEntity<Integer>(HttpStatus.NO_CONTENT);
        }
    }
    
}
