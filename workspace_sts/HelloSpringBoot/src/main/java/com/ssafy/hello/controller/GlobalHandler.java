package com.ssafy.hello.controller;

import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;

import com.ssafy.hello.util.ErrorResponse;
import com.ssafy.hello.util.HelloException;

@ControllerAdvice
public class GlobalHandler {
    
    @ExceptionHandler(Exception.class)
    public String handle(Exception e) {
        e.printStackTrace();
        
        return "error.html"; 
    }
    
    @ExceptionHandler(HelloException.class)
    @ResponseBody
    public ErrorResponse handle2(HelloException e) {
        e.printStackTrace();
        
        ErrorResponse response = new ErrorResponse();
        response.setCode(e.getCode());
        response.setMsg(e.getMessage());
        
        return response; 
    }
}
