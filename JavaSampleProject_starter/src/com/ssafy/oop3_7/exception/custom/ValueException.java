package com.ssafy.oop3_7.exception.custom;

class ValueException extends Exception {

    private static final long serialVersionUID = 1L;

    public ValueException() {
        super("ValueException:같은 값을 가질 수 없습니다.");
    }
}


