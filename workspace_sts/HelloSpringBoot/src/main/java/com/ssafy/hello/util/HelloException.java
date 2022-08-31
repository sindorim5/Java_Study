package com.ssafy.hello.util;

public class HelloException extends RuntimeException {

    /**
     * 
     */
    private static final long serialVersionUID = 3966315227147854443L;
    private String code;    
    
    public HelloException(String code, String msg) {
        super(msg);
        this.code = code;
    }

    public String getCode() {
        return code;
    }
}
