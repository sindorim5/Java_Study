package com.ssafy.ws.util;

public class DuplicateIDException extends RuntimeException {

    /**
     * 
     */
    private static final long serialVersionUID = -8709699041392834886L;
    private String errorCode;
    
    public DuplicateIDException(String errorCode, String errorMessage) {
        super(errorMessage);
        this.errorCode = errorCode;
    }
    
    public String getErrorCode() {
        return errorCode;
    }
}
