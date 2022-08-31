package com.ssafy.hello.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;

import com.ssafy.hello.util.HelloException;

@Controller
public class HelloController {
    
    private static final Logger log = LoggerFactory.getLogger(HelloController.class);

    @GetMapping("/hello")
    public String home(@ModelAttribute User user) {
        log.info("user: {}", user);
        
        if (true) {
            throw new HelloException("102", "exception 발생");
        }
        
        return "hello.html";
    }
    
    // controller 별로 exception 처리 로직이 달라짐.
//    @ExceptionHandler(RuntimeException.class) // 발생한 exception 처리
//    public String handleError(RuntimeException e) {
//        e.printStackTrace(); // 전체 trace 출력
//        return "error.html";
//    }
    
    
}
