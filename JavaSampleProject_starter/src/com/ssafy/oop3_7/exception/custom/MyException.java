package com.ssafy.oop3_7.exception.custom;

class MyException extends Exception {
    public MyException() {
        super("사용자가 만든  Exception class");
    }

    public void myMethod() {
        System.out.println("Exception 처리 문들...");
    }
}
