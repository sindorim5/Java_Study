package com.ssafy.cafe.util;

/**
 * 동일한 ID의 사용자가 이미 존재 할 경우 DuplicateUserException 을 발생시킨다. 
 *
 */
public class DuplicateUserException extends RuntimeException {
    private static final long serialVersionUID = 1L;

    public DuplicateUserException(String msg) {
        super(msg);
    }
}
