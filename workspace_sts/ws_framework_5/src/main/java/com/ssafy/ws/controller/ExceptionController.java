package com.ssafy.ws.controller;

import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;

import com.ssafy.ws.util.DuplicateIDException;
import com.ssafy.ws.util.ErrorResponse;

@ControllerAdvice
public class ExceptionController {
    
    @ExceptionHandler(DuplicateIDException.class)
    @ResponseBody
    public ErrorResponse DuplicateIDExceptionHandler(DuplicateIDException e) {
        e.printStackTrace();

        ErrorResponse response = new ErrorResponse();
        response.setErrorCode(e.getErrorCode());
        response.setErrorMessage(e.getMessage());

        return response;
    }
}
