package com.ssafy.hello.di4;

public class HelloMessageKor implements HelloMessage {
    
    public HelloMessageKor() {
        System.out.println("HelloMessageKor Contructor Call!!!!!!!!!");
    }

    public String hello(String name) {
        return "안녕하세요 " + name;
    }
    
}
